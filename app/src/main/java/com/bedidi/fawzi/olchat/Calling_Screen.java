package com.bedidi.fawzi.olchat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telecom.Call;
import android.view.View;
import android.widget.Button;

public class Calling_Screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calling_screen);
    }

    public void hangUp(View view)
    {
        Intent ContactPage = new Intent(getApplicationContext(), Contact_page.class);
        startActivity(ContactPage);
    }

    public void videoCall(View view)
    {
        Intent CallingVideoScreen = new Intent(getApplicationContext(), Calling_Video_Screen.class);
        startActivity(CallingVideoScreen);
    }
}
