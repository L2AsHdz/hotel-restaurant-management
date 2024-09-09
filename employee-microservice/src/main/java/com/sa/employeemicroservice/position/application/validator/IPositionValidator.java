package com.sa.employeemicroservice.position.application.validator;

import com.sa.employeemicroservice.common.application.exception.DuplicatedEntityException;
import com.sa.employeemicroservice.common.application.exception.EntityNotFoudException;
import com.sa.employeemicroservice.position.domain.PositionDomain;

import java.util.UUID;

public interface IPositionValidator {

    void validatePositionToCreate(PositionDomain positionDomain) throws DuplicatedEntityException;
    void validatePositionToUpdate(UUID positionId, PositionDomain positionDomain) throws EntityNotFoudException, DuplicatedEntityException;
    void validateExistsPositionByDescription(String description) throws DuplicatedEntityException;
    void validateExistsPositionByDescriptionAndNotId(String description, UUID id) throws DuplicatedEntityException;
    void validatePositionExistsById(UUID positionId) throws EntityNotFoudException;
}
