package com.example.ratha.chatapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ratha.chatapp.R;
import com.example.ratha.chatapp.enity.Message;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by ratha on 12/13/2017.
 */

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder>{


    List<Message> messages;
    Context context;
    Message message;
    public void setMessage(Message message) {
        this.message = message;
        if(null!=messages) this.messages.add(message);
        Log.e("message", "setMessage: "+message.toString());
    }

    public MessageAdapter(Context context,List<Message> messages){
        this.context=context;this.messages=messages;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.message_item_recycler,
                parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
       // Log.e("List size", "onBindViewHolder: "+messages.size());
        if(messages!=null){
            Message message=messages.get(position);
            holder.tvMessage.setText(message.getMessage()!=null ? message.getMessage():"");
        }
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    public void setMessages(List<Message> messages) {
        this.messages=messages;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvMessage;
        CircleImageView imageProfile;
        public ViewHolder(View itemView){
            super(itemView);
            tvMessage=itemView.findViewById(R.id.tvMessage);
            this.imageProfile=itemView.findViewById(R.id.imageProfile);
        }

    }

}
