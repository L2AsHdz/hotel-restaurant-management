package com.sa.clientmicroservice.client.infraestructure.output.port.db;

public interface ExistsClientOutputPort {

    boolean existsClientByNit(String nit);
    boolean existsClientByEmail(String email);
}
