package com.payway.demochat.repository;

import com.payway.demochat.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
