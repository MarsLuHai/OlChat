package com.bedidi.fawzi.olchat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Messaging_page extends AppCompatActivity {

    private ArrayList<String>       arrayList = new ArrayList<String>();
    private Boolean                 yolo = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messaging_page);
    }

    protected void receiveMessage(String msg) {
        View                        v;
        TextView                    item;
        LinearLayout                linearView = (LinearLayout) findViewById(R.id.LinearViewMsgPage);
        LayoutInflater              inflater = (LayoutInflater) getSystemService(this.LAYOUT_INFLATER_SERVICE);

        v = inflater.inflate(R.layout.item_receive_msg, null);
        item = (TextView) v.findViewById(R.id.textListReceiveItem);

        if ((item != null) && (msg.length() > 0)) {
            item.setText(msg);
            linearView.addView(v);
        }
    }

    protected void sendMessage(View view) {
        View                        v;
        TextView                    item;
        LinearLayout                linearView = (LinearLayout) findViewById(R.id.LinearViewMsgPage);
        LayoutInflater              inflater = (LayoutInflater) getSystemService(this.LAYOUT_INFLATER_SERVICE);
        EditText                    input = (EditText) findViewById(R.id.InputMsgPage);

        v = inflater.inflate(R.layout.item_send_msg, null);
        item = (TextView) v.findViewById(R.id.textListSendItem);

        //APPELLER ICI LA FONCTION POUR ENVOYER LE MESSAGE ET SI ELLE FONCTIONNE FAIRE CE QUI SUIT :

        if ((item != null) && (input.getText().length() > 0)) {
            item.setText(input.getText().toString());
            input.setText("");
            linearView.addView(v);
        }

    }

}
