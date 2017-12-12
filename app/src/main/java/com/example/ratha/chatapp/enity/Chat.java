package com.example.ratha.chatapp.enity;

import java.util.List;

/**
 * Created by ratha on 12/12/2017.
 */

public class Chat {
    List<User> users;

    public Chat(){}
    public Chat(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "users=" + users +
                '}';
    }
}
