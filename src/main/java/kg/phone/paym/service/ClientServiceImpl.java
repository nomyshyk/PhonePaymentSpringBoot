package kg.phone.paym.service;

import kg.phone.paym.model.Client;
import kg.phone.paym.model.PaymentRequest;
import kg.phone.paym.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author kasiom
 */
@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client addClient(Client c) {
        return clientRepository.save(c);
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client changeActiveStatus(Client c) {
        c.setInactive(!c.isInactive());
        return clientRepository.save(c);
    }

    @Override
    public BigDecimal getBalance(Long id) {
        return clientRepository.getBalance(id);
    }

    @Override
    public Client getClientById(Long id) {
        return clientRepository.findById(id).get();
    }

    @Override
    public Client getClientByPhoneNo(String phoneNo) {
        return clientRepository.getClientByPhoneNo(phoneNo);
    }

    @Override
    public String checkClient(String phoneNo) {
        Client client = clientRepository.getClientByPhoneNo(phoneNo);
        if(client != null){
            return client.getFio();
        }
        else{
            return "Client not found";
        }
    }

}
