package com.sa.employeemicroservice.position.application.usecase.updateposition;

import com.sa.employeemicroservice.common.UseCase;
import com.sa.employeemicroservice.common.application.exception.DuplicatedEntityException;
import com.sa.employeemicroservice.common.application.exception.EntityNotFoudException;
import com.sa.employeemicroservice.position.application.usecase.createposition.PositionRequestDto;
import com.sa.employeemicroservice.position.application.validator.IPositionValidator;
import com.sa.employeemicroservice.position.domain.PositionDomain;
import com.sa.employeemicroservice.position.infraestructure.input.port.UpdatePositionInputPort;
import com.sa.employeemicroservice.position.infraestructure.output.adapter.db.PositionDbEntityOutputAdapter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@UseCase
@RequiredArgsConstructor
public class UpdatePositionUseCase implements UpdatePositionInputPort {

    private final PositionDbEntityOutputAdapter positionDbEntityOutputAdapter;
    private final IPositionValidator positionValidator;

    @Override
    public PositionDomain updatePosition(UUID positionId, PositionRequestDto positionRequestDto) throws EntityNotFoudException, DuplicatedEntityException {
        var positionDomain = positionRequestDto.toDomain();
        positionValidator.validatePositionToUpdate(positionId, positionDomain);

        return positionDbEntityOutputAdapter.updatePosition(positionId, positionDomain);
    }
}
