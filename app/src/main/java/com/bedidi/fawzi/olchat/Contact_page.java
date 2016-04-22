package com.bedidi.fawzi.olchat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.GridView;

public class Contact_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_contact_page);
        GridView gridView = (GridView) findViewById(R.id.gridView);
        // Instance of ImageAdapter Class
        assert gridView != null;
        gridView.setAdapter(new ImageAdapter(this));
    }

    public void textOnClick(){
        final Intent i = new Intent(Contact_page.this, Messaging_page.class);
        startActivity(i);
    }

    public void addContactOnClick(){
        final Intent i = new Intent(Contact_page.this, add_contact.class);
            startActivity(i);
    }

    public void callOnClick(){
        final Intent i = new Intent(Contact_page.this, Calling_Screen.class);
        startActivity(i);
    }

    public void increaseOnClick(){
    }

    public void callOnClick(View view) {
    }

    public void increaseOnClick(View view) {
    }

    public void textOnClick(View view) {
    }

    public void addContactOnClick(View view) {
    }
}
