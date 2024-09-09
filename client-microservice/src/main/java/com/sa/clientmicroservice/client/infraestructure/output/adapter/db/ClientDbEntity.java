package com.sa.clientmicroservice.client.infraestructure.output.adapter.db;

import com.sa.clientmicroservice.client.domain.ClientDomain;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "client")
public class ClientDbEntity {

    @Id
    private UUID clientId;

    @Column
    private String nit;

    @Column
    private String fullName;

    @Column
    private LocalDate birthDate;

    @Column
    private String email;

    @Column
    private String phoneNumber;

    public static ClientDbEntity fromDomain(ClientDomain client) {
        return new ClientDbEntity(
                UUID.randomUUID(),
                client.getNit(),
                client.getFullName(),
                client.getBirthDate(),
                client.getEmail(),
                client.getPhoneNumber()
        );
    }

    public ClientDomain ToDomain() {
        return ClientDomain.builder()
                .clientId(clientId)
                .nit(nit)
                .fullName(fullName)
                .birthDate(birthDate)
                .email(email)
                .phoneNumber(phoneNumber)
                .build();
    }
}
