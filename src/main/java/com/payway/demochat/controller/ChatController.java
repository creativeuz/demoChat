package com.payway.demochat.controller;

import com.payway.demochat.model.Message;
import com.payway.demochat.model.MessageRequest;
import com.payway.demochat.service.ChatService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.UUID;

@Controller
public class ChatController {

    private final ChatService chatService;

    public ChatController(
        ChatService chatService
    ) {
        this.chatService = chatService;
    }

    @PostMapping("/newUser")
    @ResponseBody
    public void addUser(@RequestParam String name) {
        chatService.addUser(name);
    }

    @PostMapping("/newCS")
    @ResponseBody
    public void addCS(@RequestParam String name) {
        chatService.addCS(name);
    }

    @PostMapping("/send")
    @ResponseBody
    public void sendMessage(@RequestBody MessageRequest request) {
        chatService.sendMessage(request.getSenderId(), request.getReceiverId(), request.getContent(), request.getRoomId());
    }

    @GetMapping("/get")
    @ResponseBody
    public List<Message> getMessage(UUID roomId) {
        return chatService.getMessages(roomId);
    }

    @PostMapping("newRoom")
    @ResponseBody
    public void createRoom(@RequestParam String staff, String consumer) {
        chatService.createRoom(staff, consumer);
    }
}
