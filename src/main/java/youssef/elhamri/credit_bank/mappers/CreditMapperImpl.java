package youssef.elhamri.credit_bank.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import youssef.elhamri.credit_bank.dtos.*;
import youssef.elhamri.credit_bank.entities.*;

@Service
public class CreditMapperImpl {
    public ClientDTO fromClient(Client client){
        ClientDTO clientDTO=new ClientDTO();
        BeanUtils.copyProperties(client,clientDTO);
        return clientDTO;
    }
    public Client fromClientDTO(ClientDTO clientDTO){
        Client client=new Client();
        BeanUtils.copyProperties(clientDTO,client);
        return  client;
    }

    public CreditImmobilierDTO  fromCreditImmobilier(CreditImmobilier creditImmobilier){
        CreditImmobilierDTO creditImmobilierDTO=new CreditImmobilierDTO ();
        BeanUtils.copyProperties(creditImmobilier,creditImmobilierDTO);
        creditImmobilierDTO.setClientDTO(fromClient(creditImmobilier.getClient()));
        creditImmobilierDTO.setType(creditImmobilier.getClass().getSimpleName());
        return creditImmobilierDTO;
    }
    public CreditPersonnelDTO fromCreditPersonnel(CreditPersonnel creditPersonnel){
        CreditPersonnelDTO creditPersonnelDTO=new CreditPersonnelDTO ();
        BeanUtils.copyProperties(creditPersonnel,creditPersonnelDTO);
        creditPersonnelDTO.setClientDTO(fromClient(creditPersonnel.getClient()));
        creditPersonnelDTO.setType(creditPersonnel.getClass().getSimpleName());
        return creditPersonnelDTO;
    }
    public CreditProfessionelDTO fromCreditPersonnel(CreditProfessionel creditProfessionel){
        CreditProfessionelDTO creditProfessionelDTO =new CreditProfessionelDTO ();
        BeanUtils.copyProperties(creditProfessionel, creditProfessionelDTO);
        creditProfessionelDTO.setClientDTO(fromClient(creditProfessionel.getClient()));
        creditProfessionelDTO.setType(creditProfessionel.getClass().getSimpleName());
        return creditProfessionelDTO;
    }

    public CreditImmobilier fromCreditImmobilierDTO (CreditImmobilierDTO  savingBankAccountDTO){
        CreditImmobilier creditImmobilier=new CreditImmobilier();
        BeanUtils.copyProperties(savingBankAccountDTO,creditImmobilier);
        creditImmobilier.setClient(fromClientDTO(savingBankAccountDTO.getClientDTO()));
        return creditImmobilier;
    }


    public CreditPersonnel fromCreditIPersonnelDTO(CreditPersonnelDTO creditPersonnelDTO){
        CreditPersonnel creditPersonnel=new CreditPersonnel();
        BeanUtils.copyProperties(creditPersonnelDTO,creditPersonnel);
        creditPersonnel.setClient(fromClientDTO(creditPersonnelDTO.getClientDTO()));
        return creditPersonnel;
    }
    public CreditProfessionel fromCreditIProfessionelDTO(CreditProfessionelDTO creditProfessionelDTO){
        CreditProfessionel creditProfessionel=new CreditProfessionel();
        BeanUtils.copyProperties(creditProfessionelDTO,creditProfessionel);
        creditProfessionel.setClient(fromClientDTO(creditProfessionelDTO.getClientDTO()));
        return creditProfessionel;
    }

    public RemboursementDTO fromRemboursement(Remboursement remboursement){
        RemboursementDTO remboursementDTO=new RemboursementDTO();
        BeanUtils.copyProperties(remboursement,remboursementDTO);
        return remboursementDTO;
    }

}
