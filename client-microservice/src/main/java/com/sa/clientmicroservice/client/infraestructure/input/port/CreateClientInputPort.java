package com.sa.clientmicroservice.client.infraestructure.input.port;

import com.sa.clientmicroservice.client.application.usecase.createclient.CreateClientRequestDto;
import com.sa.clientmicroservice.client.domain.ClientDomain;
import com.sa.clientmicroservice.common.application.exception.DuplicatedEntityException;

public interface CreateClientInputPort {
    ClientDomain createClient(CreateClientRequestDto createClientRequest) throws DuplicatedEntityException;
}
