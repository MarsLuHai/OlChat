package com.bedidi.fawzi.olchat.database;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class MessagesDatabase extends RealmObject{

    private String message;
    private String sender;
    private String receiver;
    private Date date;

    public String getReceiver() {return receiver;}
    public String getSender() {return sender;}
    public String getMessage() {return message;}
    public Date getDate() {return date;}

    public void setDate(Date date) {this.date = date;}
    public void setMessage(String message) {this.message = message;}
    public void setReceiver(String receiver) {this.receiver = receiver;}
    public void setSender(String sender) {this.sender = sender;}
}
