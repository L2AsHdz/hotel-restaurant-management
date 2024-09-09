package com.sa.employeemicroservice.position.application.validator;

import com.sa.employeemicroservice.common.application.exception.DuplicatedEntityException;
import com.sa.employeemicroservice.common.application.exception.EntityNotFoudException;
import com.sa.employeemicroservice.position.domain.PositionDomain;
import com.sa.employeemicroservice.position.infraestructure.output.adapter.db.PositionDbEntityOutputAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PositionValidator implements IPositionValidator {

    private final PositionDbEntityOutputAdapter positionDbEntityOutputAdapter;

    @Override
    public void validatePositionToCreate(PositionDomain positionDomain) throws DuplicatedEntityException {
        validateExistsPositionByDescription(positionDomain.getDescription());
    }

    @Override
    public void validatePositionToUpdate(UUID positionId, PositionDomain positionDomain) throws EntityNotFoudException, DuplicatedEntityException {
        validatePositionExistsById(positionId);
        validateExistsPositionByDescriptionAndNotId(positionDomain.getDescription(), positionId);
    }

    @Override
    public void validateExistsPositionByDescription(String description) throws DuplicatedEntityException {
        var existsPosition = positionDbEntityOutputAdapter.existsPositionByDescription(description);

        if (existsPosition) {
            throw new DuplicatedEntityException("Position with this description already exists");
        }
    }

    @Override
    public void validateExistsPositionByDescriptionAndNotId(String description, UUID id) throws DuplicatedEntityException {
        var existsPosition = positionDbEntityOutputAdapter.existsPositionByDescriptionAndNotId(description, id);

        if (existsPosition) {
            throw new DuplicatedEntityException("Position with this description already exists");
        }
    }

    @Override
    public void validatePositionExistsById(UUID positionId) throws EntityNotFoudException {
        var existsPosition = positionDbEntityOutputAdapter.findPositionByUuid(positionId);

        if (existsPosition.isEmpty()) {
            throw new EntityNotFoudException("Position can not be found");
        }
    }
}
