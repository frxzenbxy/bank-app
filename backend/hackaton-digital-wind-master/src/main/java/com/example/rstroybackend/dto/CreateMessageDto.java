package com.example.rstroybackend.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
public class CreateMessageDto {
    @NotBlank(message = "Текст обязателен")
    private String text;
}
