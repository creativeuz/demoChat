package com.payway.demochat.service;

import com.payway.demochat.exception.UserNotFoundException;
import com.payway.demochat.model.CS;
import com.payway.demochat.model.Message;
import com.payway.demochat.model.Room;
import com.payway.demochat.model.User;
import com.payway.demochat.repository.CSRepository;
import com.payway.demochat.repository.MessageRepository;
import com.payway.demochat.repository.RoomRepository;
import com.payway.demochat.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ChatService {

    private final UserRepository userRepository;
    private final MessageRepository messageRepository;
    private final RoomRepository roomRepository;
    private final CSRepository cSRepository;

    public ChatService(
        UserRepository userRepository,
        MessageRepository messageRepository,
        RoomRepository roomRepository,
        CSRepository cSRepository
    ) {
        this.userRepository = userRepository;
        this.messageRepository = messageRepository;
        this.roomRepository = roomRepository;
        this.cSRepository = cSRepository;
    }

    public void addUser(String name) {
        userRepository.save(new User(name));
    }

    public void sendMessage(String senderId, String receiverId, String content, String roomId) {
        if(senderId.equals(null) || receiverId.equals(null) || content.equals(null) || roomId.equals(null))
            return;

        Room room =
            roomRepository.findById(UUID.fromString(roomId)).orElseThrow(() -> new UserNotFoundException(roomId));

        messageRepository.save(new Message(UUID.fromString(senderId), UUID.fromString(receiverId), content, room));
    }

    public List<Message> getMessages(UUID roomId) {
        return messageRepository.getMessagesByRoomId(roomId);
    }

    public void addCS(String name) {
        cSRepository.save(new CS(name));
    }

    public void createRoom(String staff, String consumer) {
        CS cs = cSRepository.findById(UUID.fromString(staff)).orElseThrow(() -> new UserNotFoundException(staff));
        User user =
            userRepository.findById(UUID.fromString(consumer)).orElseThrow(() -> new UserNotFoundException(consumer));
        boolean closed = false;
        roomRepository.save(new Room(cs, user, closed));
    }
}
