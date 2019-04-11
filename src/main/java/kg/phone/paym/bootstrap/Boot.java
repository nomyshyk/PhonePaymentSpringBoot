package kg.phone.paym.bootstrap;

import kg.phone.paym.model.Client;
import kg.phone.paym.model.Payment;
import kg.phone.paym.service.ClientService;
import kg.phone.paym.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import java.math.BigDecimal;

/**
 * @author kasiom
 */
@Component
public class Boot implements CommandLineRunner {

    @Autowired
    private ClientService clientService;

    @Autowired
    private PaymentService paymentService;

    @Override
    public void run(String... args) throws Exception {
        Client c = new Client();
        c.setFio("Alisher");
        c.setInactive(false);
        c.setPhoneNo("774659288");
        clientService.addClient(c);

        Client c2 = new Client();
        c2.setFio("Leo");
        c2.setInactive(false);
        c2.setPhoneNo("774669288");
        clientService.addClient(c2);

        /*Payment p1 = new Payment(c, BigDecimal.TEN, "SUCCESS");
        Payment p2 = new Payment(c2, BigDecimal.ONE, "ERROR");*/
        /*paymentService.save(p1);
        paymentService.save(p2);*/
    }
}
