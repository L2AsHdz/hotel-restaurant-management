package com.sa.employeemicroservice.position.infraestructure.input.adapter.restapi;

import com.sa.employeemicroservice.position.domain.PositionDomain;

import java.util.UUID;

public record PositionResponseDto(UUID positionId, String description, double weeklySalary) {

    public static PositionResponseDto from(PositionDomain position) {
        return new PositionResponseDto(position.getPositionId(), position.getDescription(), position.getWeeklySalary());
    }
}
