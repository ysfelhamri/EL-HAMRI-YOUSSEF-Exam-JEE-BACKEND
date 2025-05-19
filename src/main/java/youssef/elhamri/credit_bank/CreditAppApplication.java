package youssef.elhamri.credit_bank;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import youssef.elhamri.credit_bank.entities.Client;
import youssef.elhamri.credit_bank.entities.CreditImmobilier;
import youssef.elhamri.credit_bank.entities.CreditPersonnel;
import youssef.elhamri.credit_bank.entities.Remboursement;
import youssef.elhamri.credit_bank.enums.*;
import youssef.elhamri.credit_bank.repositories.*;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class CreditAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(CreditAppApplication.class, args);
    }
    @Bean
    CommandLineRunner start(ClientRepository clientRepository,
                            CreditRepository creditRepository,
                            RemboursementRepository remboursementRepository) {
        return args -> {
            Stream.of("Youssef","Mohammed","Adil").forEach(name -> {
                Client client = new Client();
                client.setName(name);
                client.setEmail(name+"@gmail.com");
                clientRepository.save(client);
            });
            clientRepository.findAll().forEach(cl->{
                CreditImmobilier creditImmobilier = new CreditImmobilier();
                creditImmobilier.setId(UUID.randomUUID().toString());
                creditImmobilier.setMontant(Math.random()*90000);
                creditImmobilier.setDemandeDate(new Date());
                creditImmobilier.setAcceptationDate(new Date());
                creditImmobilier.setStatus(CreditStatus.EN_COURS);
                creditImmobilier.setTypeImmobilier(ImmobilierType.APPARTEMENT);
                creditImmobilier.setDuree(Math.random()*10000);
                creditImmobilier.setClient(cl);
                creditImmobilier.setInteret(5.2);
                creditRepository.save(creditImmobilier);

                CreditPersonnel creditPersonnel = new CreditPersonnel();
                creditPersonnel.setId(UUID.randomUUID().toString());
                creditPersonnel.setMontant(Math.random()*90000);
                creditPersonnel.setDemandeDate(new Date());
                creditPersonnel.setAcceptationDate(new Date());
                creditPersonnel.setStatus(CreditStatus.EN_COURS);
                creditPersonnel.setDuree(Math.random()*10000);
                creditPersonnel.setClient(cl);
                creditPersonnel.setInteret(5.2);
                creditPersonnel.setMotif("credit");
                creditRepository.save(creditPersonnel);
            });
            creditRepository.findAll().forEach(cr->{
                for (int i = 0; i < 10; i++) {
                    Remboursement remboursement = new Remboursement();
                    remboursement.setType(RemboursementType.REMBOURSEMENT);
                    remboursement.setMontant(Math.random()*90000);
                    remboursement.setRemboursementDate(new Date());
                    remboursement.setCredit(cr);
                    remboursementRepository.save(remboursement);
                }
            });
        };
    }

}
