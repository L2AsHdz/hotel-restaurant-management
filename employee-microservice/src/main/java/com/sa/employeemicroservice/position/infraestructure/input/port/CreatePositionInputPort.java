package com.sa.employeemicroservice.position.infraestructure.input.port;

import com.sa.employeemicroservice.common.application.exception.DuplicatedEntityException;
import com.sa.employeemicroservice.position.application.usecase.createposition.PositionRequestDto;
import com.sa.employeemicroservice.position.domain.PositionDomain;

public interface CreatePositionInputPort {
    PositionDomain createPosition(PositionRequestDto positionRequestDto) throws DuplicatedEntityException;
}
