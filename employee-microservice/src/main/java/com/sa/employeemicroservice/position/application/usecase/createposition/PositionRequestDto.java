package com.sa.employeemicroservice.position.application.usecase.createposition;

import com.sa.employeemicroservice.position.domain.PositionDomain;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record PositionRequestDto(

        @NotBlank(message = "Name is required")
        @Size(max = 150, message = "Name must be less than 150 characters")
        String description,

        @NotNull(message = "Name is required")
        @Min(value = 1, message = "Weekly salary must be greater than 0")
        double weeklySalary
) {

    public PositionDomain toDomain() {
        return PositionDomain.builder()
                .description(description)
                .weeklySalary(weeklySalary)
                .build();
    }
}
