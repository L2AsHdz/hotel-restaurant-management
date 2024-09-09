package com.sa.employeemicroservice.position.infraestructure.input.port;

import com.sa.employeemicroservice.common.application.exception.EntityNotFoudException;
import com.sa.employeemicroservice.position.domain.PositionDomain;

import java.util.UUID;

public interface FindPositionByUuidInputPort {
    PositionDomain findPositionByUuid(UUID positionId) throws EntityNotFoudException;
}
