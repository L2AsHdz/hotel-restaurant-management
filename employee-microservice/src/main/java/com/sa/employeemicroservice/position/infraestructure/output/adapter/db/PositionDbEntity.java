package com.sa.employeemicroservice.position.infraestructure.output.adapter.db;

import com.sa.employeemicroservice.position.domain.PositionDomain;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "position")
public class PositionDbEntity {

    @Id
    private UUID positionId;

    @Column
    private String description;

    @Column
    private double weeklySalary;

    public static PositionDbEntity fromDomain(PositionDomain position) {
        return new PositionDbEntity(
                UUID.randomUUID(),
                position.getDescription(),
                position.getWeeklySalary()
        );
    }

    public PositionDomain toDomain() {
        return PositionDomain.builder()
                .positionId(positionId)
                .description(description)
                .weeklySalary(weeklySalary)
                .build();
    }
}
