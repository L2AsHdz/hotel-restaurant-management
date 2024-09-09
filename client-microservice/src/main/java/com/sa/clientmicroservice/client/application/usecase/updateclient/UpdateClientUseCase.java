package com.sa.clientmicroservice.client.application.usecase.updateclient;


import com.sa.clientmicroservice.client.application.validator.IClientValidator;
import com.sa.clientmicroservice.client.domain.ClientDomain;
import com.sa.clientmicroservice.client.infraestructure.input.port.UpdateClientInputPort;
import com.sa.clientmicroservice.client.infraestructure.output.adapter.db.ClientDbEntityOutputAdapter;
import com.sa.clientmicroservice.common.UseCase;
import com.sa.clientmicroservice.common.application.exception.DuplicatedEntityException;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@UseCase
@RequiredArgsConstructor
public class UpdateClientUseCase implements UpdateClientInputPort {

    private final ClientDbEntityOutputAdapter clientDbEntityOutputAdapter;
    private final IClientValidator clientValidator;

    @Override
    public ClientDomain updateClient(UUID uuid, UpdateClientRequestDto updateClientRequestDto) throws DuplicatedEntityException {
        clientValidator.validateClient(updateClientRequestDto.nit(), updateClientRequestDto.email());

        var client = updateClientRequestDto.ToDomain();
        client.setClientId(uuid);

        return clientDbEntityOutputAdapter.updateClient(client);
    }
}
