package youssef.elhamri.credit_bank.dtos;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import youssef.elhamri.credit_bank.enums.CreditStatus;
import youssef.elhamri.credit_bank.enums.ImmobilierType;

import java.util.Date;

@Data
public class CreditImmobilierDTO extends CreditDTO {
    private String id;
    private Date demandeDate;
    private CreditStatus status;
    private Date acceptationDate;
    private Double montant;
    private Double duree;
    private Double interet;
    private ClientDTO clientDTO;
}
