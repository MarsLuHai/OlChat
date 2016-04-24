package com.bedidi.fawzi.olchat;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bedidi.fawzi.olchat.database.ContactsDatabase;
import com.bedidi.fawzi.olchat.database.UserDatabase;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

public class Add_contact extends AppCompatActivity {

    private ListView listView;
    private EditText editText;
    private Realm realm;
    private final Context mContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(this)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
        realm = Realm.getDefaultInstance();
        listView = (ListView) findViewById(R.id.possible_contact);
        assert listView != null;
        listView.setAdapter(new AddContactAdapter(this, ""));
        editText = (EditText) findViewById(R.id.enter_id);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                listView.setAdapter(new AddContactAdapter(mContext, s.toString()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void addContactOnClick(View view){
        realm.beginTransaction();
        ContactsDatabase user = realm.createObject(ContactsDatabase.class);
        user.setUserOne(this.getIntent().getStringExtra(MainActivity.EXTRA_MESSAGE));
        Button button = (Button) view.findViewById(R.id.add_user);
        user.setUserTwo(button.getText().toString());
        final Context context = getApplicationContext();
        final int duration = Toast.LENGTH_SHORT;
        CharSequence text = "User " + user.getUserOne() + " added " + user.getUserTwo();
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        realm.copyToRealm(user);
        realm.commitTransaction();
    }
}
