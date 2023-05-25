package com.example.rstroybackend.controller;

import com.example.rstroybackend.dto.JsonPage;
import com.example.rstroybackend.dto.UpdateUserRequestDto;
import com.example.rstroybackend.entity.User;
import com.example.rstroybackend.exceptions.ConflictException;
import com.example.rstroybackend.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping(value = "/api/v1")
public class UserControllerV1 {
    private UserService userService;

    @GetMapping("/api/v1/user")
    public ResponseEntity getCurrentUser(@AuthenticationPrincipal UserDetails userDetails) {
        User currentUser = userService.findById(Long.parseLong(userDetails.getUsername()));
        return ResponseEntity.ok(currentUser);
    }

    @GetMapping("/users")
    public ResponseEntity getAllUsers(@PageableDefault(size = 30, sort = { "created" }, direction = Sort.Direction.DESC) Pageable pageable) {
        Page<User> users = userService.findAll(pageable);
        return ResponseEntity.ok(users);
    }

    @PatchMapping("/admin/user/{id}")
    public ResponseEntity updateUser(@PathVariable(name = "id", required = true) Long id, @Valid @RequestBody UpdateUserRequestDto updateUserRequestDto) {
        try {
            User updatedUser = userService.update(updateUserRequestDto, id);
            return ResponseEntity.ok(updatedUser);
        } catch (ConflictException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getBody());
        }
    }
}
