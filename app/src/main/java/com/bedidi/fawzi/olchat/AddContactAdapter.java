package com.bedidi.fawzi.olchat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.bedidi.fawzi.olchat.database.ContactsDatabase;
import com.bedidi.fawzi.olchat.database.UserDatabase;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

public class AddContactAdapter extends BaseAdapter{
    private Context mContext;
    private Realm realm;

    public String[] mThumbIds = {};

    // Constructor
    public AddContactAdapter(Context c, String username){
        mContext = c;
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(c)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
        realm = Realm.getDefaultInstance();
        RealmResults<UserDatabase> result2 = realm.where(UserDatabase.class)
                .contains("username", username)
                .findAll();
        List<String> list = new ArrayList();
        for (UserDatabase userDatabase: result2) {
                list.add(userDatabase.getUsername());
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
        View listView;

        listView = new View(mContext);
        listView = inflater.inflate(R.layout.add_contact_adapter, null);
        Button button = (Button) listView.findViewById(R.id.add_user);
        button.setText(mThumbIds[position]);
        return listView.findViewById(R.id.contact_to_add);
    }

    @Override
    public void notifyDataSetChanged(){

    }
}
