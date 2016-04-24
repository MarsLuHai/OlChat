package com.bedidi.fawzi.olchat.database;


import io.realm.RealmObject;
import io.realm.annotations.Index;
import io.realm.annotations.PrimaryKey;

public class ConversationsClass extends RealmObject{

    @PrimaryKey
    private Integer idConversation;
    @Index
    private Integer idUser;

    public Integer getIdConversation(){return idConversation;}
    public Integer getIdUser(){return idUser;}
}
