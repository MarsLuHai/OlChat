package com.bedidi.fawzi.olchat.database;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class UserDatabase extends RealmObject {

    @PrimaryKey
    private String username;
    private String password;
    private RealmList<UserDatabase> contacts;

    public String getUsername(){return username;}
    public String getPassword(){return password;}

    public RealmList<UserDatabase> getContacts() {return contacts;}

    public void setUsername(String username){this.username = username;}

    public void setPassword(String password){this.password = password;}

    public void addContacts(UserDatabase contact) {
        this.contacts.add(contact);
    }
}
