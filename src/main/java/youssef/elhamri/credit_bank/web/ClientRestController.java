package youssef.elhamri.credit_bank.web;


import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import youssef.elhamri.credit_bank.dtos.ClientDTO;
import youssef.elhamri.credit_bank.services.CreditService;

import java.util.List;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
public class ClientRestController {
    private CreditService creditService;


    @GetMapping("/clients")
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public List<ClientDTO> clients(){
        return creditService.listClients();
    }

    @GetMapping("/clients/{id}")
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public ClientDTO getClient(@PathVariable(name = "id") Long clientId) {
        return creditService.getClient(clientId);
    }
    @PostMapping("/clients")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public ClientDTO saveClient(@RequestBody ClientDTO clientDTO){
        return creditService.saveClient(clientDTO);
    }
    @PutMapping("/clients/{clientId}")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public ClientDTO updateClient(@PathVariable Long customerId, @RequestBody ClientDTO clientDTO){
        clientDTO.setId(customerId);
        return creditService.updateCustomer(clientDTO);
    }
    @DeleteMapping("/clients/{id}")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public void deleteClient(@PathVariable Long id){
        creditService.deleteClient(id);
    }

    @GetMapping("/clients/search")
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public List<ClientDTO> searchClients(@RequestParam(name = "keyword",defaultValue = "") String keyword){
        return creditService.searchClients("%"+keyword+"%");
    }
}
