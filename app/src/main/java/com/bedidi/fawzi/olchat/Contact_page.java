package com.bedidi.fawzi.olchat;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Contact_page extends AppCompatActivity {

    public final static String SENDER = "com.bedidi.fawzi.olchat.SENDER";
    public final static String RECEIVER = "com.bedidi.fawzi.olchat.RECEIVER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_contact_page);
        GridView gridView = (GridView) findViewById(R.id.gridView);
        assert gridView != null;
        final Intent intent = getIntent();
        gridView.setAdapter(new ImageAdapter(this, intent.getStringExtra(MainActivity.EXTRA_MESSAGE)));
    }

    public void textOnClick(View view) {
        final Intent i = new Intent(Contact_page.this, Messaging_page.class);
        i.putExtra(RECEIVER, this.getIntent().getStringExtra(MainActivity.EXTRA_MESSAGE));
        Button button = (Button) view.findViewById(R.id.send_text);
        i.putExtra(SENDER, button.getText().toString());
        startActivity(i);
    }

    public void addContactOnClick(View view){
        final Intent i = new Intent(Contact_page.this, Add_contact.class);
        i.putExtra(MainActivity.EXTRA_MESSAGE, this.getIntent().getStringExtra(MainActivity.EXTRA_MESSAGE));
        startActivity(i);
    }

    public void callOnClick(View view){
        final Intent i = new Intent(Contact_page.this, Calling_Screen.class);
        startActivity(i);
    }

    public void increaseOnClick(View view){
    }

    public void displayContactNameOnClick(View view){
        final Context context = getApplicationContext();
        final int duration = Toast.LENGTH_SHORT;
        CharSequence text = "d";
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
