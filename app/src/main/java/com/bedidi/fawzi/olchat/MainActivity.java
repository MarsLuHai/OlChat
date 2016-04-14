package com.bedidi.fawzi.olchat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    private EditText usernameEditText;
    private EditText passwordEditText;
    public final static String EXTRA_MESSAGE = "com.bedidi.fawzi.olchat.USERNAME";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        usernameEditText = (EditText) findViewById(R.id.username);
        passwordEditText = (EditText) findViewById(R.id.password);

    }

    protected void signIn(View view){

    }

    protected void signUp(View view){
        Intent i=new Intent(MainActivity.this, SignUp.class);

        if (usernameEditText.getText().length() >= 1){
            i.putExtra(EXTRA_MESSAGE, usernameEditText.getText().toString());
            Log.i("Main Activity","Username sent to the Signup activity");
        }
        startActivity(i);
    }
}
