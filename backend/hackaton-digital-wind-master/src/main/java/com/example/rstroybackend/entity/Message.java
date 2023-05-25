package com.example.rstroybackend.entity;

import com.example.rstroybackend.entity.views.SecurityViews;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "messages")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Message extends BaseEntity {
    @NotBlank(message = "Текст обязателен")
    @Size(min = 2, max = 50, message = "Текст должен содержать больше двух и меньше 50ти символов")
    @JsonView(SecurityViews.Anonymous.class)
    private String text;

    @ManyToOne
    @JoinColumn(name="sender_id", nullable=false)
    @JsonView(SecurityViews.User.class)
    private User sender;

    @ManyToOne
    @JoinColumn(name="conversation_id", nullable=true)
    @JsonView(SecurityViews.User.class)
    private Conversation conversation;
}
