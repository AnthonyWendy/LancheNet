package com.br.lanchenet.person.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {

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

    @Enumerated(EnumType.STRING)
    @NotNull(message = "error.user.type_user.empty")
    private TypePerson typePerson;

    @AssertTrue
    private Boolean active;
}
