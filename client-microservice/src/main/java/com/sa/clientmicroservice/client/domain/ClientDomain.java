package com.sa.clientmicroservice.client.domain;

import com.sa.clientmicroservice.common.DomainEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Builder
@DomainEntity
public class ClientDomain {

    private UUID clientId;
    private String nit;
    private String fullName;
    private LocalDate birthDate;
    private String email;
    private String phoneNumber;
}
