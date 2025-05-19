package youssef.elhamri.credit_bank.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import youssef.elhamri.credit_bank.dtos.*;
import youssef.elhamri.credit_bank.entities.*;
import youssef.elhamri.credit_bank.enums.ImmobilierType;
import youssef.elhamri.credit_bank.mappers.CreditMapperImpl;
import youssef.elhamri.credit_bank.repositories.ClientRepository;
import youssef.elhamri.credit_bank.repositories.CreditRepository;
import youssef.elhamri.credit_bank.repositories.RemboursementRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class CreditServiceImpl implements CreditService{

    private CreditRepository creditRepository;
    private ClientRepository clientRepository;
    private RemboursementRepository remboursementRepository;
    private CreditMapperImpl dtoMapper;


    @Override
    public ClientDTO saveClient(ClientDTO clientDTO) {
        Client client=dtoMapper.fromClientDTO(clientDTO);
        Client savedClient = clientRepository.save(client);
        return dtoMapper.fromClient(savedClient);
    }

    @Override
    public List<ClientDTO> listClients() {
        List<Client> clients = clientRepository.findAll();
        List<ClientDTO> clientDTOS=new ArrayList<>();
        for (Client client:clients){
            ClientDTO clientDTO=dtoMapper.fromClient(client);
            clientDTOS.add(clientDTO);
        }
        return clientDTOS;
    }

    @Override
    public CreditProfessionelDTO saveCreditProfessionel(double montant, String motif, String raisonSocial, Long clientId) {
        Client client=clientRepository.findById(clientId).orElse(null);
        CreditProfessionel creditProfessionel = new CreditProfessionel();
        creditProfessionel.setId(UUID.randomUUID().toString());
        creditProfessionel.setMontant(montant);
        creditProfessionel.setMotif(motif);
        creditProfessionel.setRaisonSocial(raisonSocial);
        creditProfessionel.setClient(client);
        CreditProfessionel savedCreditProfessionel = creditRepository.save(creditProfessionel);
        return dtoMapper.fromCreditProfessionel(savedCreditProfessionel);
    }

    @Override
    public CreditPersonnelDTO saveCreditPersonnel(double montant, String motif, Long clientId) {
        Client client=clientRepository.findById(clientId).orElse(null);
        CreditPersonnel creditPersonnel = new CreditPersonnel();
        creditPersonnel.setId(UUID.randomUUID().toString());
        creditPersonnel.setMontant(montant);
        creditPersonnel.setMotif(motif);
        creditPersonnel.setClient(client);
        CreditPersonnel savedCreditPersonnel = creditRepository.save(creditPersonnel);
        return dtoMapper.fromCreditPersonnel(savedCreditPersonnel);
    }

    @Override
    public CreditImmobilierDTO saveCreditImmobilier(double montant, ImmobilierType type, Long clientId) {
        Client client=clientRepository.findById(clientId).orElse(null);
        CreditImmobilier creditImmobilier = new CreditImmobilier();
        creditImmobilier.setId(UUID.randomUUID().toString());
        creditImmobilier.setMontant(montant);
        creditImmobilier.setType(type);
        creditImmobilier.setClient(client);
        CreditImmobilier savedCreditImmobilier = creditRepository.save(creditImmobilier);
        return dtoMapper.fromCreditImmobilier(savedCreditImmobilier);
    }

    @Override
    public List<CreditDTO> creditList() {
        List<Credit> credits = creditRepository.findAll();
        List<CreditDTO> creditDTOS = new ArrayList<>();
        for (Credit credit:credits) {
            if (credit instanceof CreditImmobilier) {
                CreditImmobilier creditImmobilier = (CreditImmobilier) credit;
                creditDTOS.add(dtoMapper.fromCreditImmobilier(creditImmobilier));
            } else if (credit instanceof CreditPersonnel) {
                CreditPersonnel creditPersonnel = (CreditPersonnel) credit;
                creditDTOS.add(dtoMapper.fromCreditPersonnel(creditPersonnel));
            }
            else {
                CreditProfessionel creditProfessionel = (CreditProfessionel) credit;
                creditDTOS.add(dtoMapper.fromCreditProfessionel(creditProfessionel));
            }
        }
        return creditDTOS;
    }

    @Override
    public CreditDTO getCredit(String accountId) {
        Credit credit=creditRepository.findById(accountId).orElse(null);
        if (credit instanceof CreditImmobilier) {
            CreditImmobilier creditImmobilier = (CreditImmobilier) credit;
            return dtoMapper.fromCreditImmobilier(creditImmobilier);
        } else if (credit instanceof CreditPersonnel) {
            CreditPersonnel creditPersonnel = (CreditPersonnel) credit;
            return dtoMapper.fromCreditPersonnel(creditPersonnel);
        }
        else {
            CreditProfessionel creditProfessionel = (CreditProfessionel) credit;
            return dtoMapper.fromCreditProfessionel(creditProfessionel);
        }
    }

    @Override
    public ClientDTO getClient(Long clientId) {
        Client client = clientRepository.findById(clientId).orElse(null);
        return dtoMapper.fromClient(client);
    }

    @Override
    public ClientDTO updateCustomer(ClientDTO clientDTO) {
        Client client=dtoMapper.fromClientDTO(clientDTO);
        Client savedClient = clientRepository.save(client);
        return dtoMapper.fromClient(savedClient);
    }

    @Override
    public void deleteClient(Long clientId) {
        clientRepository.deleteById(clientId);
    }

    @Override
    public List<ClientDTO> searchClients(String keyword) {
        List<Client> clients=clientRepository.searchClient(keyword);
        List<ClientDTO> clientDTOS = clients.stream().map(cust -> dtoMapper.fromClient(cust)).collect(Collectors.toList());
        return clientDTOS;
    }
}
