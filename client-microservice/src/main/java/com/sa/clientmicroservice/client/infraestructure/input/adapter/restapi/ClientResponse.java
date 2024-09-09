package com.sa.clientmicroservice.client.infraestructure.input.adapter.restapi;

import com.sa.clientmicroservice.client.domain.ClientDomain;

import java.time.LocalDate;

public record ClientResponse(String nit, String fullName, LocalDate birthDate, String email, String phoneNumber) {

    public static ClientResponse from(ClientDomain client) {
        return new ClientResponse(
                client.getNit(),
                client.getFullName(),
                client.getBirthDate(),
                client.getEmail(),
                client.getPhoneNumber()
        );
    }

}
