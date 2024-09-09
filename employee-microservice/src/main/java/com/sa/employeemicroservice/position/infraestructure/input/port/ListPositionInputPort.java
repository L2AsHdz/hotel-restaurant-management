package com.sa.employeemicroservice.position.infraestructure.input.port;

import com.sa.employeemicroservice.position.domain.PositionDomain;

import java.util.List;

public interface ListPositionInputPort {
    List<PositionDomain> listPositions();
}
