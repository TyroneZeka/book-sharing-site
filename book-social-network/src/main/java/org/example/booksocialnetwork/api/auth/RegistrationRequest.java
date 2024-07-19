package org.example.booksocialnetwork.api.auth;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RegistrationRequest {

    @NotEmpty(message = "First Name should not be empty")
    @NotBlank(message = "First name should not be blank")
    private String firstname;
    @NotEmpty(message = "Last Name should not be empty")
    @NotBlank(message = "Last name should not be blank")
    private String lastname;

    @NotEmpty(message = "Email should not be empty")
    @NotBlank(message = "Email should not be blank")
    @Email(message = "Email is not well formated")
    private String email;

    @NotEmpty(message = "Password should not be empty")
    @NotBlank(message = "Password should not be blank")
    @Size(min = 8,message = "Password should be at least 8 Characters long")
    private String password;
}
