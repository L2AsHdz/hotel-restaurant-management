package com.sa.clientmicroservice.client.infraestructure.input.adapter.restapi;

import com.sa.clientmicroservice.client.application.usecase.createclient.CreateClientRequestDto;
import com.sa.clientmicroservice.client.application.usecase.updateclient.UpdateClientRequestDto;
import com.sa.clientmicroservice.client.infraestructure.input.port.*;
import com.sa.clientmicroservice.common.WebAdapter;
import com.sa.clientmicroservice.common.application.exception.DuplicatedEntityException;
import com.sa.clientmicroservice.common.application.exception.EntityNotFoudException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@WebAdapter
@RequestMapping("/v1/clients")
@RequiredArgsConstructor
public class ClientRestAdapter {

    private final CreateClientInputPort createClientUseCase;
    private final ListClientsInputPort listClientsUseCase;
    private final FindClientByUuidInputPort getClientUseCase;
    private final UpdateClientInputPort updateClientUseCase;


    @GetMapping
    public ResponseEntity<List<ClientResponse>> listClients() {
        var clients = listClientsUseCase.listClients()
                .stream().map(ClientResponse::from).toList();

        return ResponseEntity.ok(clients);
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<ClientResponse> getClient(@PathVariable UUID clientId) throws EntityNotFoudException {
        var client = getClientUseCase.findClientByUuid(clientId);

        return ResponseEntity.ok(ClientResponse.from(client));
    }

    @PostMapping
    public ResponseEntity<ClientResponse> createClient(@RequestBody @Valid CreateClientRequestDto createClientRequest) throws DuplicatedEntityException {
        var client = createClientUseCase.createClient(createClientRequest);

        return ResponseEntity.created(URI.create("/v1/clients/" + client.getClientId()))
                .body(ClientResponse.from(client));
    }

    @PutMapping("/{clientId}")
    public ResponseEntity<ClientResponse> updateClient(@PathVariable UUID clientId, @RequestBody @Valid UpdateClientRequestDto updateClientRequest) throws DuplicatedEntityException {
        var client = updateClientUseCase.updateClient(clientId, updateClientRequest);

        return ResponseEntity.ok(ClientResponse.from(client));
    }
}
