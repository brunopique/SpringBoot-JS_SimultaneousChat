package com.brunopique.assignment14.repository;

import org.springframework.stereotype.Repository;

@Repository
public class MessageRepository {

    private StringBuilder messages = new StringBuilder();

    public void createMessage(String message) {
        messages.append(message);
    }

    public String getMessages() {
        return messages.toString();
    }
}
