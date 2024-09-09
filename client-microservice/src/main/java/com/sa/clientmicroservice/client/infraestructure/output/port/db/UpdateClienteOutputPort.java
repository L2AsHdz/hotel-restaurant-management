package com.sa.clientmicroservice.client.infraestructure.output.port.db;

import com.sa.clientmicroservice.client.domain.ClientDomain;

public interface UpdateClienteOutputPort {
    ClientDomain updateClient(ClientDomain client);
}
