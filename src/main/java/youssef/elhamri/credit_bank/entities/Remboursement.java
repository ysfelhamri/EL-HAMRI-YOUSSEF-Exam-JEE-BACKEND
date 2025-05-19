package youssef.elhamri.credit_bank.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import youssef.elhamri.credit_bank.enums.RemboursementType;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Remboursement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date remboursementDate;
    private Double montant;
    @Enumerated(EnumType.STRING)
    private RemboursementType type;
    @ManyToOne
    private Credit credit;
}
