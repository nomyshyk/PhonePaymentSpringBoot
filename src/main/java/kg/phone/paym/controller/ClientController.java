package kg.phone.paym.controller;

import kg.phone.paym.model.Balance;
import kg.phone.paym.model.Client;
import kg.phone.paym.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author kasiom
 */
@RestController
@RequestMapping("api/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Client addClient(@RequestBody Client c){
        return clientService.addClient(c);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    private Client changeClient(@RequestBody Client c){
        return clientService.changeActiveStatus(c);
    }

    @GetMapping("/balance/{id}")
    private Balance getBalance(@PathVariable Long id){
        return new Balance(clientService.getClientById(id),
                clientService.getBalance(id));
    }

    @GetMapping
    private List<Client> getAllClients(){
        return clientService.getAllClients();
    }

    @GetMapping("{id}")
    private Client getOneClient(@PathVariable Long id){
        return clientService.getClientById(id);
    }

    @GetMapping("/check/{phoneNo}")
    private String checkClientByPhone(@PathVariable String phoneNo){
        return clientService.checkClient(phoneNo);
    }
}
