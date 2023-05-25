package com.example.rstroybackend.repo;

import com.example.rstroybackend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ProductRepo extends JpaRepository<Product, Long> {
}
