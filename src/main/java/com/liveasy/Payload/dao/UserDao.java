package com.liveasy.Payload.dao;

import com.liveasy.Payload.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDao extends JpaRepository<User,Integer> {
    public Optional<User> findByEmail(String email);
}
