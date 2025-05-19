package youssef.elhamri.credit_bank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import youssef.elhamri.credit_bank.entities.Credit;

public interface CreditRepository extends JpaRepository<Credit, String> {
}
