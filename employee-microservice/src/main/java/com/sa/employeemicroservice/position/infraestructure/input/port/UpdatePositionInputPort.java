package com.sa.employeemicroservice.position.infraestructure.input.port;

import com.sa.employeemicroservice.common.application.exception.DuplicatedEntityException;
import com.sa.employeemicroservice.common.application.exception.EntityNotFoudException;
import com.sa.employeemicroservice.position.application.usecase.createposition.PositionRequestDto;
import com.sa.employeemicroservice.position.domain.PositionDomain;

import java.util.UUID;

public interface UpdatePositionInputPort {
    PositionDomain updatePosition(UUID positionId, PositionRequestDto positionRequestDto) throws EntityNotFoudException, DuplicatedEntityException;
}
