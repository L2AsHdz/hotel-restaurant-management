package com.sa.clientmicroservice.client.infraestructure.input.adapter.restapi;

import com.sa.clientmicroservice.client.application.usecase.createclient.CreateClientRequestDto;
import com.sa.clientmicroservice.client.infraestructure.input.port.CreateClientInputPort;
import com.sa.clientmicroservice.client.infraestructure.input.port.ListClientsInputPort;
import com.sa.clientmicroservice.common.WebAdapter;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;
import java.util.List;

@WebAdapter
@RequestMapping("/v1/clients")
@RequiredArgsConstructor
public class ClientRestAdapter {

    private final CreateClientInputPort createClientUseCase;
    private final ListClientsInputPort listClientsUseCase;


    @GetMapping
    public ResponseEntity<List<ClientResponse>> listClients() {
        var clients = listClientsUseCase.listClients()
                .stream().map(ClientResponse::from).toList();

        return ResponseEntity.ok(clients);
    }

    @PostMapping
    public ResponseEntity<ClientResponse> createClient(@RequestBody @Valid CreateClientRequestDto createClientRequest) {
        var client = createClientUseCase.createClient(createClientRequest);

        return ResponseEntity.created(URI.create("/v1/clients/" + client.getClientId()))
                .body(ClientResponse.from(client));
    }
}
