package com.sa.clientmicroservice.client.infraestructure.input.port;

import com.sa.clientmicroservice.client.domain.ClientDomain;
import com.sa.clientmicroservice.common.application.exception.EntityNotFoudException;

import java.util.UUID;

public interface FindClientByUuidInputPort {
    ClientDomain findClientByUuid(UUID clientId) throws EntityNotFoudException;
}
