package com.sa.employeemicroservice.position.infraestructure.output.port.db;

import com.sa.employeemicroservice.position.domain.PositionDomain;

public interface CreatePositionOutputPort {
    PositionDomain createPosition(PositionDomain positionDomain);
}
