package com.brunopique.assignment14.service;

import com.brunopique.assignment14.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public void createMessage(String message) {
        messageRepository.createMessage(message);
    }

    public String getMessages() {
        return messageRepository.getMessages();
    }
}

