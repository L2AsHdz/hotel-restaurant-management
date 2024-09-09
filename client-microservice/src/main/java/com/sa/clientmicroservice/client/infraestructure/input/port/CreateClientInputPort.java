package com.sa.clientmicroservice.client.infraestructure.input.port;

import com.sa.clientmicroservice.client.application.usecase.createclient.CreateClientRequestDto;
import com.sa.clientmicroservice.client.domain.ClientDomain;

public interface CreateClientInputPort {
    ClientDomain createClient(CreateClientRequestDto createClientRequest);
}
