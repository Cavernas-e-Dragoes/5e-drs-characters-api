package com.ced.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import static com.ced.constants.ApplicationConstants.USERS;

@Setter
@Getter
@Document(collection = USERS)
public class User {

    @Size(min = 4, max = 100, message = "O campo 'name' deve ter entre 4 e 100 caracteres")
    @NotBlank(message = "O campo 'name' nao pode ser nulo ou vazio")
    private String name;
    @Indexed(unique = true)
    @Size(min = 4, max = 100, message = "O campo 'email' deve ter entre 4 e 100 caracteres")
    @NotBlank(message = "O campo 'email' nao pode ser nulo ou vazio")
    private String email;
    @Size(min = 4, max = 100, message = "O campo 'password' deve ter entre 4 e 100 caracteres")
    @NotBlank(message = "O campo 'password' nao pode ser nulo ou vazio")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

}
