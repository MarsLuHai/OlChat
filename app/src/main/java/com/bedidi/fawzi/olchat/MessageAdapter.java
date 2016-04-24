package com.bedidi.fawzi.olchat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.bedidi.fawzi.olchat.database.MessagesDatabase;
import com.bedidi.fawzi.olchat.database.UserDatabase;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

/**
 * Created by Fawzi on 24/04/16.
 */
public class MessageAdapter extends BaseAdapter {
    private Context mContext;
    private Realm realm;
    private final String receiver;
    private final String sender;

    public MessagesDatabase[] mThumbIds = {};

    public MessageAdapter(Context c, String receiver, String sender){
        mContext = c;
        this.receiver =receiver;
        this.sender = sender;

        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(c)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
        realm = Realm.getDefaultInstance();
        RealmResults<MessagesDatabase> result2 = realm.where(MessagesDatabase.class)
                .equalTo("sender", sender)
                .or()
                .equalTo("receiver", receiver)
                .or()
                .equalTo("receiver", sender)
                .or()
                .equalTo("sender", receiver)
                .findAll().sort("date");
        List<MessagesDatabase> list = new ArrayList();
        for (MessagesDatabase messagesDatabase: result2) {
            list.add(messagesDatabase);
        }
        mThumbIds = list.toArray(new MessagesDatabase[list.size()]);
    }

    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return mThumbIds[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View message = null;
        if (mThumbIds[position].getReceiver().equals(receiver)) {
            message =  inflater.inflate(R.layout.item_receive_msg, null);
           TextView textView = (TextView) message.findViewById(R.id.textListReceiveItem);
            textView.setText(mThumbIds[position].getMessage());
        }
        else if (mThumbIds[position].getSender().equals(receiver) || mThumbIds[position].getReceiver().equals(sender)){
            message =  inflater.inflate(R.layout.item_send_msg, null);
            TextView textView = (TextView) message.findViewById(R.id.textListSendItem);
            textView.setText(mThumbIds[position].getMessage());
        }
        return message;
    }

    @Override
    public void notifyDataSetChanged(){

    }
}
