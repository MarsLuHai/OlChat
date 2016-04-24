package com.bedidi.fawzi.olchat.database;

import io.realm.RealmObject;

public class ContactsDatabase extends RealmObject{

    private String userOne;
    private String userTwo;

    public String getUserOne() {return userOne;}

    public String getUserTwo() {return userTwo;}

    public void setUserOne(String userOne) {this.userOne = userOne;}
    public void setUserTwo(String userTwo) {this.userTwo = userTwo;}
}
