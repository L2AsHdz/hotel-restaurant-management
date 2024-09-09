package com.sa.clientmicroservice.client.infraestructure.output.adapter.db;

import com.sa.clientmicroservice.client.domain.ClientDomain;
import com.sa.clientmicroservice.client.infraestructure.output.port.db.*;
import com.sa.clientmicroservice.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@PersistenceAdapter
@RequiredArgsConstructor
public class ClientDbEntityOutputAdapter
        implements
        CreateClientOutputPort,
        ExistsClientOutputPort,
        UpdateClienteOutputPort,
        ListClientsOutputPort,
        FindClientByUuidOutputPort
{

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

    @Override
    public Optional<ClientDomain> FindClientByUuid(UUID clientId) {
        return clientDBEntityRepository.findById(clientId).map(ClientDbEntity::ToDomain);
    }
}
