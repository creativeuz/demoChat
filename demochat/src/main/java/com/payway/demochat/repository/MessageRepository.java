package com.payway.demochat.repository;

import com.payway.demochat.model.Message;
import com.payway.demochat.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

}
