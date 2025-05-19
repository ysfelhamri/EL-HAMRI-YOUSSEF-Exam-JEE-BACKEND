package youssef.elhamri.credit_bank.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import youssef.elhamri.credit_bank.enums.CreditStatus;

import java.util.Date;
import java.util.List;
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE",length = 4)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Credit {
    @Id
    private String id;
    private Date demandeDate;
    @Enumerated(EnumType.STRING)
    private CreditStatus status;
    private Date acceptationDate;
    private Double montant;
    private Double duree;
    private Double interet;
    @ManyToOne
    private Client client;
    @OneToMany (mappedBy = "credit",fetch = FetchType.EAGER)
    private List<Remboursement> remboursement;
}
