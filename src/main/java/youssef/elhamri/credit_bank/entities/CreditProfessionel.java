package youssef.elhamri.credit_bank.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("CPR")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditProfessionel extends Credit{
    private String motif;
    private String raisonSocial;

}
