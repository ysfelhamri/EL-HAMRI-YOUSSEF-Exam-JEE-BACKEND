package youssef.elhamri.credit_bank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import youssef.elhamri.credit_bank.entities.Remboursement;

public interface RemboursementRepository extends JpaRepository<Remboursement, String> {
}
