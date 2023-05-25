package com.example.rstroybackend.controller;

import com.example.rstroybackend.dto.CreateMessageDto;
import com.example.rstroybackend.entity.Conversation;
import com.example.rstroybackend.entity.Message;
import com.example.rstroybackend.entity.User;
import com.example.rstroybackend.enums.Status;
import com.example.rstroybackend.exceptions.BadRequestException;
import com.example.rstroybackend.repo.ConversationRepo;
import com.example.rstroybackend.repo.UserRepo;
import com.example.rstroybackend.service.ConversationService;
import com.example.rstroybackend.service.MessageService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping(value = "/api/v1")

public class MessageControllerV1 {
    private MessageService messageService;
    private ConversationService conversationService;
    private UserRepo userRepo;
    private ConversationRepo conversationRepo;

    @PostMapping("/messages")
    public ResponseEntity createMessage(@Valid @RequestBody CreateMessageDto createMessageDto) {
        User user = userRepo.findById(Long.valueOf(1)).orElse(null);

        if (user == null) {
            throw new BadRequestException();
        }

        List<Conversation> conversationsArray = new ArrayList<>(user.getAssignedConversations());

        Conversation activeConversation = conversationsArray.stream().filter((conversation -> conversation.getStatus() == Status.ACTIVE)).findFirst().orElse(null);

        Message newMessage = new Message();
        newMessage.setText(createMessageDto.getText());

        if (activeConversation != null) {
            Set<Message> messagesCopy = new HashSet(activeConversation.getMessages());
            messagesCopy.add(newMessage);
            activeConversation.setMessages(messagesCopy);
            conversationRepo.save(activeConversation);
        } else {
            Conversation newConversation = new Conversation();
            Set<Message> messages = new HashSet();
            messages.add(newMessage);
            newConversation.setClient(user);
            newConversation.setMessages(messages);
            conversationRepo.save(newConversation);
        }

        return ResponseEntity.ok(newMessage);
    }

    @GetMapping("/conversations")
    public ResponseEntity getAllConversations(@PageableDefault(size = 30, sort = { "created" }, direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Conversation> conversations = conversationService.findAll(pageable);
        return ResponseEntity.ok(conversations);
    }
}
