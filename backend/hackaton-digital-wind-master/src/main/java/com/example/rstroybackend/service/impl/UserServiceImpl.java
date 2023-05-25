package com.example.rstroybackend.service.impl;

import com.example.rstroybackend.dto.UpdateUserRequestDto;
import com.example.rstroybackend.entity.*;
import com.example.rstroybackend.exceptions.*;
import com.example.rstroybackend.repo.*;
import com.example.rstroybackend.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    private final RoleRepo roleRepo;

    @Override
    public Page<User> findAll(Pageable pageable) {
        Page<User> users = userRepo.findAll(pageable);

        log.info("IN getAll - {} users found", users.getNumberOfElements());
        return users;
    }

    @Override
    public User findById(Long userId) {
        User result = userRepo.findById(userId).orElse(null);

        if (result == null) {
            log.warn("IN findById - no user found by id: {}", userId);
            throw new ResourceNotFoundException();
        }

        log.info("IN findById - user {} found by id: {}", result, userId);
        return result;
    }

    @Override
    public User update(UpdateUserRequestDto updateCurrentUserRequestDto, Long userId) {
        User currentUser = findById(userId);

        Role roleUser = roleRepo.findByName(updateCurrentUserRequestDto.getRole()).orElse(null);
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(roleUser);
        currentUser.setRoles(userRoles);
        currentUser.setName(updateCurrentUserRequestDto.getName());
        currentUser.setUpdated(new Date());

        User result = userRepo.save(currentUser);

        if (result == null) {
            log.info("IN update - user with id: {} update: {} failed", userId, result);
            throw new InternalServerErrorException();
        }
        log.info("IN update - user with id: {} successfully updated: {}", userId, result);

        return result;
    }
}
