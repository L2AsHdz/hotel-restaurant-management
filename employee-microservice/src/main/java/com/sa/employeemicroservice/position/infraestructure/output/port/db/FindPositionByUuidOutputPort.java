package com.sa.employeemicroservice.position.infraestructure.output.port.db;

import com.sa.employeemicroservice.position.domain.PositionDomain;

import java.util.Optional;
import java.util.UUID;

public interface FindPositionByUuidOutputPort {
    Optional<PositionDomain> findPositionByUuid(UUID id);
}
