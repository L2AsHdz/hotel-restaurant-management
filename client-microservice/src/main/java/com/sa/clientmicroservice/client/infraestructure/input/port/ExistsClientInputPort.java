package com.sa.clientmicroservice.client.infraestructure.input.port;

public interface ExistsClientInputPort {
    boolean existsClientByNit(String nit);
    boolean existsClientByEmail(String email);
}
