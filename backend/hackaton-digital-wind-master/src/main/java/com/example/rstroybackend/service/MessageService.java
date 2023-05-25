package com.example.rstroybackend.service;

import com.example.rstroybackend.entity.Message;
import com.example.rstroybackend.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MessageService {
    Page<Message> findAll (Pageable pageable);
    Message create(Message product);
}
