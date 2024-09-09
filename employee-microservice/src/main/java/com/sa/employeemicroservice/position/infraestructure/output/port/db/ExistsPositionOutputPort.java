package com.sa.employeemicroservice.position.infraestructure.output.port.db;

import java.util.UUID;

public interface ExistsPositionOutputPort {
    boolean existsPositionByDescription(String description);
    boolean existsPositionByDescriptionAndNotId(String description, UUID id);
}
