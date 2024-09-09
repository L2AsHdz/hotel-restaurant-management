package com.sa.employeemicroservice.position.infraestructure.output.adapter.db;

import com.sa.employeemicroservice.common.PersistenceAdapter;
import com.sa.employeemicroservice.position.domain.PositionDomain;
import com.sa.employeemicroservice.position.infraestructure.output.port.db.*;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@PersistenceAdapter
@RequiredArgsConstructor
public class PositionDbEntityOutputAdapter
    implements
        CreatePositionOutputPort,
        UpdatePositionOutputPort,
        ListPositionOutputPort,
        FindPositionByUuidOutputPort,
        ExistsPositionOutputPort
{

    private final PositionDbEnitityRepository positionDbEnitityRepository;

    @Override
    public PositionDomain createPosition(PositionDomain positionDomain) {
        var positionDbEntity = PositionDbEntity.fromDomain(positionDomain);
        return positionDbEnitityRepository.save(positionDbEntity).toDomain();
    }

    @Override
    public boolean existsPositionByDescription(String description) {
        return positionDbEnitityRepository.existsByDescription(description);
    }

    @Override
    public boolean existsPositionByDescriptionAndNotId(String description, UUID id) {
        return positionDbEnitityRepository.existsByDescriptionAndPositionIdNot(description, id);
    }

    @Override
    public Optional<PositionDomain> findPositionByUuid(UUID id) {
        return positionDbEnitityRepository.findById(id).map(PositionDbEntity::toDomain);
    }

    @Override
    public List<PositionDomain> listPositions() {
        return positionDbEnitityRepository.findAll().stream()
                .map(PositionDbEntity::toDomain).toList();
    }

    @Override
    public PositionDomain updatePosition(UUID positionId, PositionDomain positionDomain) {
        var positionDbEntity = PositionDbEntity.fromDomain(positionDomain);
        positionDbEntity.setPositionId(positionId);

        return positionDbEnitityRepository.save(positionDbEntity).toDomain();
    }
}
