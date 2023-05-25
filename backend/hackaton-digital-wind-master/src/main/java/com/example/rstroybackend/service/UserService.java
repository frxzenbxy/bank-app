package com.example.rstroybackend.service;

import com.example.rstroybackend.dto.*;
import com.example.rstroybackend.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Set;

public interface UserService {
    Page<User> findAll(Pageable pageable);

    User findById(Long userId);

    User update(UpdateUserRequestDto updateUserRequestDto, Long userId);
}
