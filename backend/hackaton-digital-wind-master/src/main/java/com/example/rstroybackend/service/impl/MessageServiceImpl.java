package com.example.rstroybackend.service.impl;


import com.example.rstroybackend.entity.Message;
import com.example.rstroybackend.entity.Product;
import com.example.rstroybackend.entity.User;
import com.example.rstroybackend.enums.Status;
import com.example.rstroybackend.exceptions.InternalServerErrorException;
import com.example.rstroybackend.repo.MessageRepo;
import com.example.rstroybackend.service.MessageService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
@AllArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final MessageRepo messageRepo;

    @Override
    public Page<Message> findAll(Pageable pageable) {
        Page<Message> message = messageRepo.findAll(pageable);

        log.info("IN getAll - {} message found", message.getNumberOfElements());
        return message;
    }

    @Override
    public Message create(Message message) {
        message.setStatus(Status.ACTIVE);
        message.setCreated(new Date());
        message.setUpdated(new Date());

        Message createdMessage = messageRepo.save(message);

        if (createdMessage == null) {
            throw new InternalServerErrorException();
        }

        return createdMessage;
    }
}
