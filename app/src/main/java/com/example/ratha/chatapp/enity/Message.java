package com.example.ratha.chatapp.enity;

import java.util.Date;

/**
 * Created by ratha on 12/12/2017.
 */

public class Message {
    private int id;
    private int userId;
    private String message;
    private Boolean isActive;
    private Date date;

    public Message(){}
    public Message(int id, int userId, String message, Date date) {
        this.id = id;
        this.userId = userId;
        this.message = message;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", userId=" + userId +
                ", message='" + message + '\'' +
                ", isActive='" + isActive + '\'' +
                ", date=" + date +
                '}';
    }
}
