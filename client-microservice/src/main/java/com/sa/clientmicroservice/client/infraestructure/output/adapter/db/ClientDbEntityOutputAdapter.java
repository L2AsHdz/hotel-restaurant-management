package com.sa.clientmicroservice.client.infraestructure.output.adapter.db;

import com.sa.clientmicroservice.client.domain.ClientDomain;
import com.sa.clientmicroservice.client.infraestructure.output.port.db.CreateClientOutputPort;
import com.sa.clientmicroservice.client.infraestructure.output.port.db.ExistsClientOutputPort;
import com.sa.clientmicroservice.client.infraestructure.output.port.db.ListClientsOutputPort;
import com.sa.clientmicroservice.client.infraestructure.output.port.db.UpdateClienteOutputPort;
import com.sa.clientmicroservice.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@PersistenceAdapter
@RequiredArgsConstructor
public class ClientDbEntityOutputAdapter
        implements
        CreateClientOutputPort,
        ExistsClientOutputPort,
        UpdateClienteOutputPort,
        ListClientsOutputPort {

    private final ClientDBEntityRepository clientDBEntityRepository;

    @Override
    public ClientDomain storeClient(ClientDomain client) {
        var clientDbEntity = ClientDbEntity.fromDomain(client);
        return clientDBEntityRepository.save(clientDbEntity).ToDomain();
    }

    @Override
    public boolean existsClientByNit(String nit) {
        return clientDBEntityRepository.existsClientDbEntitiesByNit(nit);
    }

    @Override
    public boolean existsClientByEmail(String email) {
        return clientDBEntityRepository.existsClientDbEntitiesByEmail(email);
    }

    @Override
    public ClientDomain updateClient(ClientDomain client) {
        var clientDBEntity = ClientDbEntity.fromDomain(client);
        return clientDBEntityRepository.save(clientDBEntity).ToDomain();
    }

    @Override
    public List<ClientDomain> listClients() {
        return clientDBEntityRepository.findAll()
                .stream().map(ClientDbEntity::ToDomain).toList();
    }
}
