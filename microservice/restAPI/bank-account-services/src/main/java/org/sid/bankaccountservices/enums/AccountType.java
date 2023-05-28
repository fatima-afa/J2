package org.sid.bankaccountservices.enums;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


public enum AccountType {
    CURRENT_ACCOUNT,
    SAVING_ACCOUNT
}
