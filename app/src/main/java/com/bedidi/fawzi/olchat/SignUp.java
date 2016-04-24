package com.bedidi.fawzi.olchat;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.bedidi.fawzi.olchat.database.UserDatabase;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;

public class SignUp extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private EditText password2EditText;
    private Realm realm;

    private final static String USERNAME_CREATED = "com.bedidi.fawzi.olchat.USERNAME";
    private final static String PASSWORD_CREATED = "com.bedidi.fawzi.olchat.USERNAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        final Intent intent = getIntent();
        final String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        usernameEditText = (EditText) findViewById(R.id.username);
        passwordEditText = (EditText) findViewById(R.id.password);
        password2EditText = (EditText) findViewById(R.id.password2);
        usernameEditText.setText(message);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(this)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
        realm = Realm.getDefaultInstance();
    }

    public void signUp(View view){
        final Intent i = new Intent(SignUp.this, MainActivity.class);
        if (usernameEditText.getText().length() >= 1
                && password2EditText.getText().toString().equalsIgnoreCase(passwordEditText.getText().toString())
                && passwordEditText != null) {
            i.putExtra(USERNAME_CREATED, usernameEditText.getText().toString());
            i.putExtra(PASSWORD_CREATED, passwordEditText.getText().toString());
            realm.beginTransaction();
            UserDatabase user = realm.createObject(UserDatabase.class);
            user.setUsername(usernameEditText.getText().toString());
            user.setPassword(passwordEditText.getText().toString());
            realm.copyToRealm(user);
            realm.commitTransaction();
            startActivity(i);
        }
        else {
            final Context context = getApplicationContext();
            final int duration = Toast.LENGTH_SHORT;
            CharSequence text = "Toast";

            if (usernameEditText.getText().length() < 1) {
                text = "Please chose a username";
            }
            else if (passwordEditText.getText().length() < 1 || password2EditText.getText().length() < 1) {
                text = "Please enter a password";
            }
            else if (!password2EditText.getText().toString().equalsIgnoreCase(passwordEditText.getText().toString())) {
                text = "both password should be the same";
            }
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

}
