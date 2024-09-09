package com.sa.clientmicroservice.client.infraestructure.input.port;

import com.sa.clientmicroservice.client.domain.ClientDomain;

import java.util.List;

public interface ListClientsInputPort {
    List<ClientDomain> listClients();
}
