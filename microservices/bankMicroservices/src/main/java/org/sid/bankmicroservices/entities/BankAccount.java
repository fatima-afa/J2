package org.sid.bankmicroservices.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.bankmicroservices.enums.AccountType;

import java.util.Date;
@Entity
@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class BankAccount {
     @Id
    private String id;
    private Date createdAt;
    private double balance;
    private String currency;
    private AccountType type;
}
