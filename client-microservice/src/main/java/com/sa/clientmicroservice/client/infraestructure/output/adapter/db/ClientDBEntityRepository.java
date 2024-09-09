package com.sa.clientmicroservice.client.infraestructure.output.adapter.db;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientDBEntityRepository extends JpaRepository<ClientDbEntity, UUID> {
    boolean existsClientDbEntitiesByNit(String nit);
    boolean existsClientDbEntitiesByEmail(String email);
}
