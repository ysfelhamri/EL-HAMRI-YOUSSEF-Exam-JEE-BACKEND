package youssef.elhamri.credit_bank.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("CPE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditPersonnel extends Credit{
    private String motif;

}
