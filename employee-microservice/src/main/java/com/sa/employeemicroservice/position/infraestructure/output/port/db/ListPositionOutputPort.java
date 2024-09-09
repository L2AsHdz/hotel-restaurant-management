package com.sa.employeemicroservice.position.infraestructure.output.port.db;

import com.sa.employeemicroservice.position.domain.PositionDomain;

import java.util.List;

public interface ListPositionOutputPort {
    List<PositionDomain> listPositions();
}
