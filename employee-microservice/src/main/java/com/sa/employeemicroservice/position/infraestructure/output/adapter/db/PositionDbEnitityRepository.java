package com.sa.employeemicroservice.position.infraestructure.output.adapter.db;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PositionDbEnitityRepository extends JpaRepository<PositionDbEntity, UUID> {
    boolean existsByDescription(String description);
    boolean existsByDescriptionAndPositionIdNot(String description, UUID id);
}
