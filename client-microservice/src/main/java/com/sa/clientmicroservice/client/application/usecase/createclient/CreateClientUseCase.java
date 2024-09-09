package com.sa.clientmicroservice.client.application.usecase.createclient;

import com.sa.clientmicroservice.client.application.validator.IClientValidator;
import com.sa.clientmicroservice.client.domain.ClientDomain;
import com.sa.clientmicroservice.client.infraestructure.input.port.CreateClientInputPort;
import com.sa.clientmicroservice.client.infraestructure.output.adapter.db.ClientDbEntityOutputAdapter;
import com.sa.clientmicroservice.common.UseCase;
import com.sa.clientmicroservice.common.application.exception.DuplicatedEntityException;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class CreateClientUseCase implements CreateClientInputPort {

    private final ClientDbEntityOutputAdapter clientDbEntityOutputAdapter;
    private final IClientValidator clientValidator;

    @Override
    public ClientDomain createClient(CreateClientRequestDto createClientRequest) throws DuplicatedEntityException {
        clientValidator.validateClient(createClientRequest.nit(), createClientRequest.email());

        var client = createClientRequest.ToDomain();
        return clientDbEntityOutputAdapter.storeClient(client);
    }
}
