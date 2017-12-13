package com.example.ratha.chatapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ratha.chatapp.adapter.MessageAdapter;
import com.example.ratha.chatapp.enity.Message;
import com.example.ratha.chatapp.enity.User;
import com.example.ratha.chatapp.service.FireBaseChat;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    DatabaseReference ref;
    private RecyclerView chatRecyclerView;
    private EditText etMessage;
    private static User user= new User(1,"rathana","NaNa","rathana@gmail.com");
    //data
    private List<Message> messages;
    private MessageAdapter messageAdapter;
    private FireBaseChat fireBaseChat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //init chat app
        fireBaseChat=new FireBaseChat();
        ref= fireBaseChat.initFireBaseApp(FireBaseChat.ROOT_NODE);
        //initChat();

        //render UI
        this.chatRecyclerView=findViewById(R.id.chatRecyclerView);
        this.etMessage =findViewById(R.id.edMessage);
        //setup recyclerView for chat
        messages=new ArrayList<>();
        messageAdapter=new MessageAdapter(this,messages);
        this.chatRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.chatRecyclerView.setAdapter(messageAdapter);

        //write message
        //writeMessage(user);
        getMessages(ref);
        getMessage(ref);
        //getMessagesMemory();
    }



    private void getMessagesMemory() {
        for(int i=0 ;i<10;i++){
            messages.add(new Message(i,1,"how are you?"+i));
        }
        messageAdapter.setMessages(messages);
    }

    private void getMessage(DatabaseReference ref) {
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(null!=FireBaseChat.MESSAGE_NODE_KEY){
                    Message message=dataSnapshot.child(FireBaseChat.MESSAGE_NODE).
                            child(FireBaseChat.MESSAGE_NODE_KEY).getValue(Message.class);
                    messages.add(message);
                    messageAdapter.notifyItemInserted(messages.size());
                    Log.e("new message->", "work");
                }else {
                    Log.e("new message->", "no new message send0.");
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    private void getMessages(DatabaseReference reference) {
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //Message message=dataSnapshot.getKey();
                Iterator<DataSnapshot> itr= dataSnapshot.child(FireBaseChat.MESSAGE_NODE).getChildren().iterator();
                while (itr.hasNext()){
                    Message message =itr.next().getValue(Message.class);
                    messages.add(message);

                    Log.e("messages-> ", "onDataChange: "+message.toString());
                }
                messageAdapter.setMessages(messages);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    private void initChat() {
        List<User> list=new ArrayList<>();
        list.add(user);
        list.add(new User(2,"Polen","JJ Pen","polen.sok@gmail.com"));
        for (User user:list){
            fireBaseChat.writeUser(ref,user);
        }
    }

    private void writeMessage(User user ,Message message){
        fireBaseChat.writeMessage(ref,message);
    }

    public void onSendMessage(View view) {
        Message message=new Message(user.getId(),user.getId(),
                this.etMessage.getText().toString(),
                fireBaseChat.getCurrentDate());
        writeMessage(user,message);
        getMessage(ref);
    }
}
