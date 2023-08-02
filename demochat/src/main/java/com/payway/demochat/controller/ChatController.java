package com.payway.demochat.controller;

import com.payway.demochat.model.Message;
import com.payway.demochat.repository.CSupportRepository;
import com.payway.demochat.repository.MessageRepository;
import com.payway.demochat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CSupportRepository cSupportRepository;
    @Autowired
    private MessageRepository messageRepository;

    @MessageMapping("/chat/{userId}")
    @SendTo("/queue/{userId}")
    public void sendMessage(@DestinationVariable Message message) {
        //TODO: better check
        if (cSupportRepository.findById(message.getSenderId()).isEmpty()) {
            return;
        }
        messageRepository.save(message);
        sendToUser(message);
    }

    public void sendToUser(Message message) {
        messagingTemplate.convertAndSendToUser(
            userRepository.findById(message.getRecieverId()).get().getUserName(),
            "/queue/notification",
            message
        );
    }
}
