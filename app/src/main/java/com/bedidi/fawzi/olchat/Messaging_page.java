package com.bedidi.fawzi.olchat;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bedidi.fawzi.olchat.database.MessagesDatabase;
import com.bedidi.fawzi.olchat.database.UserDatabase;

import java.util.ArrayList;
import java.util.Calendar;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class Messaging_page extends AppCompatActivity {

    private ArrayList<String>       arrayList = new ArrayList<>();
    private Boolean                 yolo = true;
    private Realm realm;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messaging_page);
        listView = (ListView) findViewById(R.id.messageDisplay);
        listView.setAdapter(new MessageAdapter(this, this.getIntent().getStringExtra(Contact_page.RECEIVER), this.getIntent().getStringExtra(Contact_page.SENDER)));
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(this)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
        realm = Realm.getDefaultInstance();
    }


    public void sendMessage(View view){
        EditText editText = (EditText) findViewById(R.id.InputMsgPage);
        String msgToSend = editText.getText().toString();
        realm.beginTransaction();
        MessagesDatabase message = realm.createObject(MessagesDatabase.class);
        message.setMessage(msgToSend);
        message.setReceiver(this.getIntent().getStringExtra(Contact_page.SENDER));
        message.setSender(this.getIntent().getStringExtra(Contact_page.RECEIVER));
        message.setDate(Calendar.getInstance().getTime());
        realm.copyToRealm(message);
        listView.setAdapter(new MessageAdapter(this, this.getIntent().getStringExtra(Contact_page.SENDER), this.getIntent().getStringExtra(Contact_page.RECEIVER)));
        final Context context = getApplicationContext();
        final int duration = Toast.LENGTH_SHORT;
        CharSequence text = this.getIntent().getStringExtra(Contact_page.SENDER) + " received a message from " + this.getIntent().getStringExtra(Contact_page.RECEIVER);
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        realm.commitTransaction();
    }

/*
    protected void receiveMessage(String msg) {
        View                        v;
        TextView                    item;
        LinearLayout                linearView = (LinearLayout) findViewById(R.id.LinearViewMsgPage);
        LayoutInflater              inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);

        v = inflater.inflate(R.layout.item_receive_msg, null);
        item = (TextView) v.findViewById(R.id.textListReceiveItem);

        if ((item != null) && (msg.length() > 0)) {
            item.setText(msg);
            assert linearView != null;
            linearView.addView(v);
        }
    }

    protected void sendMessage(View view) {
        View                        v;
        TextView                    item;
        LinearLayout                linearView = (LinearLayout) findViewById(R.id.LinearViewMsgPage);
        LayoutInflater              inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        EditText                    input = (EditText) findViewById(R.id.InputMsgPage);

        v = inflater.inflate(R.layout.item_send_msg, null);
        item = (TextView) v.findViewById(R.id.textListSendItem);

        assert input != null;
        if ((item != null) && (input.getText().length() > 0)) {
            item.setText(input.getText().toString());
            input.setText("");
            assert linearView != null;
            linearView.addView(v);
        }

    }
*/
}
