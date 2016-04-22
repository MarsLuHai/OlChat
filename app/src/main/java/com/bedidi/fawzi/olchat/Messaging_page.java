package com.bedidi.fawzi.olchat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;

public class Messaging_page extends AppCompatActivity {

    private ArrayList<String>       arrayList = new ArrayList<>();
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
        LayoutInflater              inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);

        v = inflater.inflate(R.layout.item_receive_msg, null);
        item = (TextView) v.findViewById(R.id.textListReceiveItem);

        if ((item != null) && (msg.length() > 0)) {
            item.setText(msg);
            assert linearView != null;
            linearView.addView(v);
        }
    }

    protected void sendMessage() {
        View                        v;
        TextView                    item;
        LinearLayout                linearView = (LinearLayout) findViewById(R.id.LinearViewMsgPage);
        LayoutInflater              inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        EditText                    input = (EditText) findViewById(R.id.InputMsgPage);

        v = inflater.inflate(R.layout.item_send_msg, null);
        item = (TextView) v.findViewById(R.id.textListSendItem);

        //APPELLER ICI LA FONCTION POUR ENVOYER LE MESSAGE ET SI ELLE FONCTIONNE FAIRE CE QUI SUIT :

        assert input != null;
        if ((item != null) && (input.getText().length() > 0)) {
            item.setText(input.getText().toString());
            input.setText("");
            assert linearView != null;
            linearView.addView(v);
        }

    }

    public void sendMessage(View view) {
    }
}
