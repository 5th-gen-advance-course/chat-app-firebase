package com.example.ratha.chatapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ratha.chatapp.enity.Message;
import com.example.ratha.chatapp.enity.User;
import com.example.ratha.chatapp.service.FireBaseChat;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    DatabaseReference ref;
    private static User user= new User(1,"rathana","NaNa","rathana@gmail.com");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //init chat app
        ref=FireBaseChat.initFireBaseApp(FireBaseChat.ROOT_NODE);
        //initChat();

        //render UI


        //write message
        writeMessage(user);
    }

    private void initChat() {
        List<User> list=new ArrayList<>();
        list.add(user);
        list.add(new User(2,"Polen","JJ Pen","polen.sok@gmail.com"));
        for (User user:list){
            FireBaseChat.writeUser(ref,user);
        }
    }

    private void writeMessage(User user){
        Message message=new Message(user.getId(),1,"hello",
                FireBaseChat.getCurrentDate());

        FireBaseChat.writeMessage(ref,message);
    }


}
