package com.sa.employeemicroservice.position.application.usecase.createposition;

import com.sa.employeemicroservice.common.UseCase;
import com.sa.employeemicroservice.common.application.exception.DuplicatedEntityException;
import com.sa.employeemicroservice.position.application.validator.IPositionValidator;
import com.sa.employeemicroservice.position.domain.PositionDomain;
import com.sa.employeemicroservice.position.infraestructure.input.port.CreatePositionInputPort;
import com.sa.employeemicroservice.position.infraestructure.output.adapter.db.PositionDbEntityOutputAdapter;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class CreatePositionUseCase implements CreatePositionInputPort {

    private final PositionDbEntityOutputAdapter positionDbEntityOutputAdapter;
    private final IPositionValidator positionValidator;

    @Override
    public PositionDomain createPosition(PositionRequestDto positionRequestDto) throws DuplicatedEntityException {
        var position = positionRequestDto.toDomain();
        positionValidator.validatePositionToCreate(position);

        return positionDbEntityOutputAdapter.createPosition(position);
    }
}
