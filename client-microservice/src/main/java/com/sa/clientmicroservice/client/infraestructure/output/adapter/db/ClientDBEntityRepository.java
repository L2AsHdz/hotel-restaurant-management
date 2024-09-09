package com.sa.clientmicroservice.client.infraestructure.output.adapter.db;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientDBEntityRepository extends JpaRepository<ClientDbEntity, String> {
    boolean existsClientDbEntitiesByNit(String nit);
    boolean existsClientDbEntitiesByEmail(String email);
}
