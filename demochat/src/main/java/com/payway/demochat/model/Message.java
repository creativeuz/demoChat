package com.payway.demochat.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;

import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
public class Message {

    @Id
    private UUID messageId;
    private Long senderId;
    private Long recieverId;
    private ZonedDateTime sentTime;
    private String content;


    public UUID getMessageId() {
        return messageId;
    }

    public void setMessageId(UUID messageId) {
        this.messageId = messageId;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Long getRecieverId() {
        return recieverId;
    }

    public void setRecieverId(Long recieverId) {
        this.recieverId = recieverId;
    }

    public ZonedDateTime getSentTime() {
        return sentTime;
    }

    public void setSentTime(ZonedDateTime sentTime) {
        this.sentTime = sentTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
