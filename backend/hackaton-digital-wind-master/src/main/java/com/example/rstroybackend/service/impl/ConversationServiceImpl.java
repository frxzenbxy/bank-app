package com.example.rstroybackend.service.impl;

import com.example.rstroybackend.dto.UpdateUserRequestDto;
import com.example.rstroybackend.entity.Conversation;
import com.example.rstroybackend.entity.Role;
import com.example.rstroybackend.entity.User;
import com.example.rstroybackend.exceptions.InternalServerErrorException;
import com.example.rstroybackend.exceptions.ResourceNotFoundException;
import com.example.rstroybackend.repo.ConversationRepo;
import com.example.rstroybackend.repo.RoleRepo;
import com.example.rstroybackend.repo.UserRepo;
import com.example.rstroybackend.service.ConversationService;
import com.example.rstroybackend.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Service
@Slf4j
@AllArgsConstructor
public class ConversationServiceImpl implements ConversationService {

    private final ConversationRepo conversationRepo;

    @Override
    public Page<Conversation> findAll(Pageable pageable) {
        Page<Conversation> conversations = conversationRepo.findAll(pageable);
        return conversations;
    }

    @Override
    public Conversation findById(Long conversationId) {
        Conversation result = conversationRepo.findById(conversationId).orElse(null);

        if (result == null) {
            throw new ResourceNotFoundException();
        }

        return result;
    }
}
