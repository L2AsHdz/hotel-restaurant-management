package com.sa.clientmicroservice.client.application.usecase.existsclient;

import com.sa.clientmicroservice.client.infraestructure.input.port.ExistsClientInputPort;
import com.sa.clientmicroservice.client.infraestructure.output.adapter.db.ClientDbEntityOutputAdapter;
import com.sa.clientmicroservice.common.UseCase;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class ExistsClientUseCase implements ExistsClientInputPort {

    private final ClientDbEntityOutputAdapter clientDbEntityOutputAdapter;

    @Override
    public boolean existsClientByNit(String nit) {
        return clientDbEntityOutputAdapter.existsClientByNit(nit);
    }

    @Override
    public boolean existsClientByEmail(String email) {
        return clientDbEntityOutputAdapter.existsClientByEmail(email);
    }
}
