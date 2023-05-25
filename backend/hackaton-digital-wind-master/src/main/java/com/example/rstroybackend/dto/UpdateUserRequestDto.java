package com.example.rstroybackend.dto;

import com.example.rstroybackend.entity.Role;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UpdateUserRequestDto {
    @NotBlank(message = "Имя обязательно к заполнению")
    @Size(min = 2, max = 50, message = "Имя должно содержать больше двух и меньше 50ти символов")
    private String name;

    private String role;
}
