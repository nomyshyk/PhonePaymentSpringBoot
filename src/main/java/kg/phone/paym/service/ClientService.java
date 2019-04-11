package kg.phone.paym.service;

import kg.phone.paym.model.Client;
import kg.phone.paym.model.PaymentRequest;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author kasiom
 */
public interface ClientService {
    Client addClient(Client c);
    List<Client> getAllClients();
    Client changeActiveStatus(Client c);
    BigDecimal getBalance(Long id);
    Client getClientById(Long id);
    Client getClientByPhoneNo(String phoneNo);
    String checkClient(String p);
}
