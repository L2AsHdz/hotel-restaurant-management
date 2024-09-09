package com.sa.clientmicroservice.client.infraestructure.input.port;

import com.sa.clientmicroservice.client.application.usecase.updateclient.UpdateClientRequestDto;
import com.sa.clientmicroservice.client.domain.ClientDomain;

public interface UpdateClientInputPort {
    ClientDomain updateClient(Long id, UpdateClientRequestDto updateClientRequestDto);
}