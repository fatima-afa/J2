package org.sid.bankaccountservices;

import org.sid.bankaccountservices.entities.BankAccount;
import org.sid.bankaccountservices.enums.AccountType;
import org.sid.bankaccountservices.reposetories.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class BankAccountServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankAccountServicesApplication.class, args);
    }

    @Bean
    CommandLineRunner start(BankAccountRepository bankAccountRepository){

        return args -> {
            for(int i=0;i<10;i++){
                BankAccount bankAccount=BankAccount.builder()
                        .id(UUID.randomUUID().toString())
                        .accountType(Math.random()>0.5? AccountType.SAVING_ACCOUNT:AccountType.CURRENT_ACCOUNT)
                        .balance(1000+Math.random()*9000)
                        .createAt(new Date())
                        .currency("MAD")
                        .build();
                bankAccountRepository.save(bankAccount);
            }

        };

    }

}
