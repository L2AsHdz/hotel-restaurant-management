package com.sa.clientmicroservice.client.application.usecase.createclient;

import com.sa.clientmicroservice.client.domain.ClientDomain;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record CreateClientRequestDto(

        @NotEmpty(message = "The nit is required")
        @Size(max = 15, message = "The nit must have a maximum of 15 characters")
        String nit,

        @NotEmpty(message = "The full name is required")
        @Size(max = 150, message = "The full name must have a maximum of 150 characters")
        String fullName,

        @NotNull(message = "The birth date is required")
        @Past(message = "The birth date must be in the past")
        LocalDate birthDate,

        @NotBlank(message = "The email is required")
        @Email(message = "The email must be valid")
        String email,

        @NotBlank(message = "The phone number is required")
        @Size(max = 15, message = "The phone number must have a maximum of 15 characters")
        String phoneNumber
) {

    public ClientDomain ToDomain() {
        return ClientDomain.builder()
                .nit(nit)
                .fullName(fullName)
                .birthDate(birthDate)
                .email(email)
                .phoneNumber(phoneNumber)
                .build();
    }
}
