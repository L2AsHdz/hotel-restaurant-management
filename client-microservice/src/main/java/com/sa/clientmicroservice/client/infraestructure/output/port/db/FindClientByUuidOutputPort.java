package com.sa.clientmicroservice.client.infraestructure.output.port.db;

import com.sa.clientmicroservice.client.domain.ClientDomain;

import java.util.Optional;
import java.util.UUID;

public interface FindClientByUuidOutputPort {
    Optional<ClientDomain> FindClientByUuid(UUID clientId);
}
