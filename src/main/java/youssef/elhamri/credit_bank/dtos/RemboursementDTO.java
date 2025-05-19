package youssef.elhamri.credit_bank.dtos;

import lombok.Data;
import youssef.elhamri.credit_bank.enums.RemboursementType;

import java.util.Date;

@Data
public class RemboursementDTO {
    private Long id;
    private Date remboursementDate;
    private Double montant;
    private RemboursementType type;
}
