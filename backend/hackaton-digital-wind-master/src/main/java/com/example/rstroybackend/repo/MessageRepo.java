package com.example.rstroybackend.repo;

import com.example.rstroybackend.entity.Conversation;
import com.example.rstroybackend.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepo extends JpaRepository<Message, Long> {
}
