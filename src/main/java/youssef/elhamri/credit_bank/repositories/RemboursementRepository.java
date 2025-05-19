package youssef.elhamri.credit_bank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import youssef.elhamri.credit_bank.entities.BankAccount;

public interface RemboursementRepository extends JpaRepository<BankAccount, String> {
}
