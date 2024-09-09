package com.sa.clientmicroservice.client.application.usecase.findclient;

import com.sa.clientmicroservice.client.domain.ClientDomain;
import com.sa.clientmicroservice.client.infraestructure.input.port.FindClientByUuidInputPort;
import com.sa.clientmicroservice.client.infraestructure.output.adapter.db.ClientDbEntityOutputAdapter;
import com.sa.clientmicroservice.common.UseCase;
import com.sa.clientmicroservice.common.application.exception.EntityNotFoudException;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@UseCase
@RequiredArgsConstructor
public class FindClientByUuidUseCase implements FindClientByUuidInputPort {

    private final ClientDbEntityOutputAdapter clientDbEntityOutputAdapter;

    @Override
    public ClientDomain findClientByUuid(UUID clientId) throws EntityNotFoudException {
        return clientDbEntityOutputAdapter.FindClientByUuid(clientId)
                .orElseThrow(() ->  new EntityNotFoudException("Client not found"));
    }
}
