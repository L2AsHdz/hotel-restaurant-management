package com.sa.clientmicroservice.client.application.usecase.updateclient;


import com.sa.clientmicroservice.client.domain.ClientDomain;
import com.sa.clientmicroservice.client.infraestructure.input.port.UpdateClientInputPort;
import com.sa.clientmicroservice.client.infraestructure.output.adapter.db.ClientDbEntityOutputAdapter;
import com.sa.clientmicroservice.common.UseCase;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class UpdateClientUseCase implements UpdateClientInputPort {

    private final ClientDbEntityOutputAdapter clientDbEntityOutputAdapter;

    @Override
    public ClientDomain updateClient(Long id, UpdateClientRequestDto updateClientRequestDto) {
        // TODO: validaciones

        // TODO: Actualizar cliente

        // TODO: Retornar cliente actualizado
        return null;
    }
}
