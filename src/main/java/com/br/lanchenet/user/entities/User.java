package com.br.lanchenet.user.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "error.user.name.empty")
    @Size(max = 50)
    private String name;

    @Email(message = "error.eventsUser.email.format")
    @Size(max = 50, message = "error.eventsUser.email.size")
    @NotEmpty(message = "error.eventsUser.email.empty")
    private String email;

    @NotBlank(message = "error.user.password.empty")
    @Size(max = 50)
    private String password;

    @NotBlank(message = "error.user.type_user.empty")
    private TypeUser typeUser;

    @AssertTrue
    private Boolean active;
}
