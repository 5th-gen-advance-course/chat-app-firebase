package com.example.ratha.chatapp.service;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.security.Key;
import java.util.Date;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ratha on 12/12/2017.
 */

public class FireBaseChat {
    public static final String ROOT_NODE="chats";
    public static final String USER_NODE="users";
    public static final String MESSAGE_NODE="message";
    public static String ROOT_NODE_KEY;
    public static String USER_NODE_KEY;
    public static String MESSAGE_NODE_KEY;

    protected static FirebaseDatabase database=FirebaseDatabase.getInstance();
    protected static DatabaseReference reference;

    public static DatabaseReference getReference(String rootNode){
        return database.getReference(rootNode);
    }
    public static DatabaseReference initFireBaseApp(String rootNode){
        return database.getReference(rootNode);
    }

    synchronized public static <T> void writeUser(DatabaseReference reference, T t){
        USER_NODE_KEY = reference.child(USER_NODE).push().getKey();
        Map<String ,Object> updateValue=new HashMap<>();
        updateValue.put("/"+USER_NODE+"/"+ USER_NODE_KEY,t);
        reference.updateChildren(updateValue);
    }

     synchronized public static <T> void writeMessage(DatabaseReference reference,T t){
        MESSAGE_NODE_KEY =reference.child(MESSAGE_NODE).push().getKey();
        Map<String ,Object> updateValue=new HashMap<>();
        updateValue.put("/"+MESSAGE_NODE+"/"+MESSAGE_NODE_KEY,t);
        reference.updateChildren(updateValue);
    }

    public static Date getCurrentDate(){
        return Calendar.getInstance().getTime();
    }


}
