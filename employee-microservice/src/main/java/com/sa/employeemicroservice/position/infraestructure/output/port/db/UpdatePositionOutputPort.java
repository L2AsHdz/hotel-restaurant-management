package com.sa.employeemicroservice.position.infraestructure.output.port.db;

import com.sa.employeemicroservice.position.domain.PositionDomain;

import java.util.UUID;

public interface UpdatePositionOutputPort {
    PositionDomain updatePosition(UUID positionId, PositionDomain positionDomain);
}
