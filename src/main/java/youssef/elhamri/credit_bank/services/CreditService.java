package youssef.elhamri.credit_bank.services;

import youssef.elhamri.credit_bank.dtos.*;
import youssef.elhamri.credit_bank.entities.CreditImmobilier;
import youssef.elhamri.credit_bank.entities.CreditProfessionel;
import youssef.elhamri.credit_bank.enums.ImmobilierType;
import youssef.elhamri.credit_bank.exceptions.BalanceNotSufficientException;
import youssef.elhamri.credit_bank.exceptions.BankAccountNotFoundException;
import youssef.elhamri.credit_bank.exceptions.CustomerNotFoundException;

import java.util.List;

public interface CreditService {
    ClientDTO saveClient(ClientDTO clientDTO);
    List<ClientDTO> listClients();


    CreditProfessionelDTO saveCreditProfessionel(double montant, String motif,String raisonSocial, Long clientId);
    CreditPersonnelDTO saveCreditPersonnel(double montant, String motif, Long clientId);
    CreditImmobilierDTO saveCreditImmobilier(double montant, ImmobilierType type, Long clientId);

    List<CreditDTO> creditList();
    CreditDTO getCredit(String accountId) ;

    ClientDTO getClient(Long clientId);

    ClientDTO updateCustomer(ClientDTO clientDTO);

    void deleteClient(Long clientId);


    List<ClientDTO> searchClients(String keyword);
}
