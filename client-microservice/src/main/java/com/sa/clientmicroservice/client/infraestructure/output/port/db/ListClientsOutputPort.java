package com.sa.clientmicroservice.client.infraestructure.output.port.db;

import com.sa.clientmicroservice.client.domain.ClientDomain;

import java.util.List;

public interface ListClientsOutputPort {

    List<ClientDomain> listClients();
}
