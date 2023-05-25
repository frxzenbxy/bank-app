package com.example.rstroybackend.repo;

import com.example.rstroybackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
