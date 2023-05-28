package org.sid.bankaccountservices.reposetories;

import org.sid.bankaccountservices.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface BankAccountRepository extends JpaRepository<BankAccount, String> {
    public BankAccount findById(String id);

}
