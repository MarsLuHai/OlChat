package com.bedidi.fawzi.olchat;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;

import com.bedidi.fawzi.olchat.database.ContactsDatabase;
import com.bedidi.fawzi.olchat.database.UserDatabase;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private Realm realm;

    private String[] mThumbIds = {};

    // Constructor
    public ImageAdapter(Context c, String username){
        mContext = c;
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(c)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
        realm = Realm.getDefaultInstance();
        RealmResults<ContactsDatabase> result2 = realm.where(ContactsDatabase.class)
                .equalTo("userOne", username)
                .or()
                .equalTo("userTwo", username)
                .findAll();
        List<String> list = new ArrayList();
        for (ContactsDatabase contactsDatabase: result2) {
            if (contactsDatabase.getUserOne() != null && contactsDatabase.getUserOne().equals(username)) {
                list.add(contactsDatabase.getUserTwo());
            }
            else if (contactsDatabase.getUserTwo().equals(username)) {
                list.add(contactsDatabase.getUserOne());
            }
        }
        mThumbIds = list.toArray(new String[list.size()]);
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
        View gridView;

        gridView = new View(mContext);
        gridView = inflater.inflate(R.layout.contact_view, null);
        TextView textView = (TextView) gridView.findViewById(R.id.contactName);
        textView.setText(mThumbIds[position]);
        Button button2;
        button2 = (Button) gridView.findViewById(R.id.send_text);
        button2.setText(mThumbIds[position]);
        return gridView.findViewById(R.id.contact);
    }
}
