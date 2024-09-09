package com.sa.clientmicroservice.client.application.usecase.listclients;

import com.sa.clientmicroservice.client.domain.ClientDomain;
import com.sa.clientmicroservice.client.infraestructure.input.port.ListClientsInputPort;
import com.sa.clientmicroservice.client.infraestructure.output.adapter.db.ClientDbEntityOutputAdapter;
import com.sa.clientmicroservice.common.UseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class ListClientUseCase implements ListClientsInputPort {

    private final ClientDbEntityOutputAdapter clientDbEntityOutputAdapter;


    @Override
    public List<ClientDomain> listClients() {
        return clientDbEntityOutputAdapter.listClients();
    }
}
