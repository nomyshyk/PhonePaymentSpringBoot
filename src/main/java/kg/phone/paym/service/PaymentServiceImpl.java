package kg.phone.paym.service;

import kg.phone.paym.model.Client;
import kg.phone.paym.model.Payment;
import kg.phone.paym.model.PaymentRequest;
import kg.phone.paym.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author kasiom
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private ClientService clientService;



    @Override
    public Payment save(PaymentRequest p) {
        Client client =
            clientService.getClientByPhoneNo(p.getPhoneNo());
        if(client != null){
            Payment payment = new Payment(client, p.getSumma());
            return paymentRepository.save(payment);
        }
        return null;
    }

    @Override
    public Payment confirmPayment(Long paymentId) {
        Payment p = paymentRepository.findById(paymentId).get();
        p.setStatus("SUCCESS");
        return paymentRepository.save(p);
    }

    @Override
    public List<Payment> getAllPaymentsOfClient(Long clientId) {
        return paymentRepository.getClientPayments(clientId);
    }

    @Override
    public List<Payment> getAllPaymByParams(String phoneNo, String fio, String status) {
        return paymentRepository.getPaymentsByParam(phoneNo, fio, status);
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }
}
