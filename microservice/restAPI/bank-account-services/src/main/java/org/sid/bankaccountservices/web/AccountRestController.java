package org.sid.bankaccountservices.web;

import lombok.AllArgsConstructor;
import org.sid.bankaccountservices.entities.BankAccount;
import org.sid.bankaccountservices.reposetories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class AccountRestController {
    @Autowired
    private BankAccountRepository bankAccountRepository;

    public AccountRestController(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @GetMapping("/bankAccounts")//la1ere regle de rest full c'est si la classe apelle account maping est accounts
    public List<BankAccount> bankAccounts(){
        return bankAccountRepository.findAll();

    }
    @GetMapping("bankAccounts/{id}")
    //parametre qui va etre recuperer d'apres le path
    public BankAccount bankAccount(@PathVariable String id){
        return bankAccountRepository.findById(id);
                //.orElseThrow(()->new RuntimeException(String.format("Account %s not found",id)));

    }

    @PostMapping("bankAccounts")
    public BankAccount save(@RequestBody BankAccount bankAccount){
     if(bankAccount.getId()==null) bankAccount.setId(UUID.randomUUID().toString());
        return bankAccountRepository.save(bankAccount);
    }
    @PutMapping("bankAccounts/{id}",@RequestBody BankAccount bankAccount)
    public BankAccount update(@PathVariable String id,@RequestBody BankAccount bankAccount){
        BankAccount account=bankAccountRepository.findById(id).orElseThrow();
       if(bankAccount.getBalance() != null) account.setBalance(bankAccount.getBalance());
       if(bankAccount.getAccountType() !=null) account.setAccountType(bankAccount.getAccountType());
       if(bankAccount.getCurrency() !=null)  account.setCurrency(bankAccount.getCurrency());
       if(bankAccount.getCreateAt() !=null)  account.setCreateAt(bankAccount.getCreateAt());
        return bankAccountRepository.save(account);
    }
    @DeleteMapping("bankAccounts/{id}")
    public void deleteAccount(@PathVariable String id){
         bankAccountRepository.deleteById(id);
    }

}
