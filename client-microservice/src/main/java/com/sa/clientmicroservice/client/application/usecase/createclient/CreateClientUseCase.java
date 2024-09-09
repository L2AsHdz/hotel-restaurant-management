package com.sa.clientmicroservice.client.application.usecase.createclient;

import com.sa.clientmicroservice.client.domain.ClientDomain;
import com.sa.clientmicroservice.client.infraestructure.input.port.CreateClientInputPort;
import com.sa.clientmicroservice.client.infraestructure.output.adapter.db.ClientDbEntityOutputAdapter;
import com.sa.clientmicroservice.common.UseCase;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class CreateClientUseCase implements CreateClientInputPort {

    private final ClientDbEntityOutputAdapter clientDbEntityOutputAdapter;

    @Override
    public ClientDomain createClient(CreateClientRequestDto createClientRequest) {
        // TODO: Validate that client does not exist

        var client = createClientRequest.ToDomain();
        return clientDbEntityOutputAdapter.storeClient(client);
    }
}
