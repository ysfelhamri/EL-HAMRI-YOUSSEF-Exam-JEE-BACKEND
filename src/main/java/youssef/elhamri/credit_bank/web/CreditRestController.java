package youssef.elhamri.credit_bank.web;


import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import youssef.elhamri.credit_bank.dtos.ClientDTO;
import youssef.elhamri.credit_bank.dtos.CreditDTO;
import youssef.elhamri.credit_bank.services.CreditService;

import java.util.List;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
public class CreditRestController {
    private CreditService creditService;


    @GetMapping("/credits")
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public List<CreditDTO> credits(){
        return creditService.creditList();
    }

    @GetMapping("/Credits/{id}")
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public CreditDTO getCredit(@PathVariable(name = "id") String creditId) {
        return creditService.getCredit(creditId);
    }

}
