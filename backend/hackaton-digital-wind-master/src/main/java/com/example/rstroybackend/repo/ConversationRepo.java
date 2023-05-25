package com.example.rstroybackend.repo;

import com.example.rstroybackend.entity.Conversation;
import com.example.rstroybackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ConversationRepo extends JpaRepository<Conversation, Long> {
}
