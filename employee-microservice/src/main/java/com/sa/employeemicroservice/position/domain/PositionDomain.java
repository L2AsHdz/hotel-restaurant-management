package com.sa.employeemicroservice.position.domain;

import com.sa.employeemicroservice.common.DomainEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
@DomainEntity
public class PositionDomain {
    UUID positionId;
    String description;
    double weeklySalary;
}
