package com.sa.clientmicroservice.client.infraestructure.input.port;

import com.sa.clientmicroservice.client.application.usecase.updateclient.UpdateClientRequestDto;
import com.sa.clientmicroservice.client.domain.ClientDomain;
import com.sa.clientmicroservice.common.application.exception.DuplicatedEntityException;

import java.util.UUID;

public interface UpdateClientInputPort {
    ClientDomain updateClient(UUID uuid, UpdateClientRequestDto updateClientRequestDto) throws DuplicatedEntityException;
}