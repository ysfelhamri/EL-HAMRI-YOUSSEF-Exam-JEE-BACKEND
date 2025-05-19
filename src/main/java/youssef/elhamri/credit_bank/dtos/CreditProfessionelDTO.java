package youssef.elhamri.credit_bank.dtos;

import lombok.Data;
import youssef.elhamri.credit_bank.enums.CreditStatus;

import java.util.Date;

@Data
public class CreditProfessionelDTO extends CreditDTO {
    private String id;
    private Date demandeDate;
    private CreditStatus status;
    private Date acceptationDate;
    private Double montant;
    private Double duree;
    private Double interet;
    private String motif;
    private String raisonSocial;
    private ClientDTO clientDTO;
}
