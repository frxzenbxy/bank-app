package com.example.rstroybackend.entity;

import com.example.rstroybackend.entity.views.SecurityViews;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "conversations")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Conversation extends BaseEntity {
    @ManyToOne
    @JoinColumn(name="assignee_id", nullable=true)
    @JsonView(SecurityViews.User.class)
    private User assignee;

    @ManyToOne
    @JoinColumn(name="client_id", nullable=false)
    @JsonView(SecurityViews.User.class)
    private User client;

    @OneToMany(mappedBy="conversation", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private Set<Message> messages;
}
