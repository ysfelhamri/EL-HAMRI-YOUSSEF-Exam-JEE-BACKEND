package youssef.elhamri.credit_bank.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import youssef.elhamri.credit_bank.enums.CreditStatus;
import youssef.elhamri.credit_bank.enums.ImmobilierType;

@Entity
@DiscriminatorValue("CIM")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditImmobilier extends Credit{
    @Enumerated(EnumType.ORDINAL)
    private ImmobilierType typeImmobilier;

}
