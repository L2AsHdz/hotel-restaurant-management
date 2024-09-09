package com.sa.clientmicroservice.client.application.validator;

import com.sa.clientmicroservice.client.infraestructure.output.adapter.db.ClientDbEntityOutputAdapter;
import com.sa.clientmicroservice.common.application.exception.DuplicatedEntityException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientValidator implements IClientValidator {

    private final ClientDbEntityOutputAdapter clientDbEntityOutputAdapter;

    @Override
    public void validateClient(String nit, String email) throws DuplicatedEntityException {
        validateNit(nit);
        validateEmail(email);
    }

    @Override
    public void validateNit(String nit) throws DuplicatedEntityException {
        var clientExistsByNit = clientDbEntityOutputAdapter.existsClientByNit(nit);

        if (clientExistsByNit) {
            throw new DuplicatedEntityException("Client with NIT " + nit + " already exists");
        }
    }

    @Override
    public void validateEmail(String email) throws DuplicatedEntityException {
        var clientExistsByEmail = clientDbEntityOutputAdapter.existsClientByEmail(email);

        if (clientExistsByEmail) {
            throw new DuplicatedEntityException("Client with email " + email + " already exists");
        }
    }
}
