package com.sa.employeemicroservice.position.application.usecase.listposition;

import com.sa.employeemicroservice.common.UseCase;
import com.sa.employeemicroservice.position.domain.PositionDomain;
import com.sa.employeemicroservice.position.infraestructure.input.port.ListPositionInputPort;
import com.sa.employeemicroservice.position.infraestructure.output.adapter.db.PositionDbEntityOutputAdapter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class ListPositionUseCase implements ListPositionInputPort {

    private final PositionDbEntityOutputAdapter positionDbEntityOutputAdapter;

    @Override
    public List<PositionDomain> listPositions() {
        return positionDbEntityOutputAdapter.listPositions();
    }
}
