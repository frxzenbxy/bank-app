package com.example.rstroybackend.service;

import com.example.rstroybackend.dto.UpdateUserRequestDto;
import com.example.rstroybackend.entity.Conversation;
import com.example.rstroybackend.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ConversationService {
    Page<Conversation> findAll(Pageable pageable);
    Conversation findById(Long conversationId);
}
