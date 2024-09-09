package com.sa.employeemicroservice.position.application.usecase.findposition;

import com.sa.employeemicroservice.common.UseCase;
import com.sa.employeemicroservice.common.application.exception.EntityNotFoudException;
import com.sa.employeemicroservice.position.domain.PositionDomain;
import com.sa.employeemicroservice.position.infraestructure.input.port.FindPositionByUuidInputPort;
import com.sa.employeemicroservice.position.infraestructure.output.adapter.db.PositionDbEntityOutputAdapter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@UseCase
@RequiredArgsConstructor
public class FindPositionUseCase implements FindPositionByUuidInputPort {

    private final PositionDbEntityOutputAdapter positionDbEntityOutputAdapter;

    @Override
    public PositionDomain findPositionByUuid(UUID positionId) throws EntityNotFoudException {
        return positionDbEntityOutputAdapter.findPositionByUuid(positionId)
                .orElseThrow(() -> new EntityNotFoudException("Position not found"));
    }
}
