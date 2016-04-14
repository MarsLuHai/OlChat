package com.bedidi.fawzi.olchat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.EditText;

public class SignUp extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private EditText password2EditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        usernameEditText = (EditText) findViewById(R.id.username);
        passwordEditText = (EditText) findViewById(R.id.password);
        password2EditText = (EditText) findViewById(R.id.password2);
        usernameEditText.setText(message);
    }
}
