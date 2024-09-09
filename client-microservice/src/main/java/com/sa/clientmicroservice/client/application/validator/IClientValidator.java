package com.sa.clientmicroservice.client.application.validator;

import com.sa.clientmicroservice.common.application.exception.DuplicatedEntityException;

public interface IClientValidator {

    void validateClient(String nit, String email) throws DuplicatedEntityException;
    void validateNit(String nit) throws DuplicatedEntityException;
    void validateEmail(String email) throws DuplicatedEntityException;
}
