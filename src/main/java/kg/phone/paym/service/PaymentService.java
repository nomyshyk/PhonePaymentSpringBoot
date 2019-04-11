package kg.phone.paym.service;

import kg.phone.paym.model.Client;
import kg.phone.paym.model.Payment;
import kg.phone.paym.model.PaymentRequest;

import java.util.List;

/**
 * @author kasiom
 */
public interface PaymentService {

    Payment save(PaymentRequest p);
    Payment confirmPayment(Long paymentId);
    List<Payment> getAllPaymentsOfClient(Long clientId);
    List<Payment> getAllPaymByParams(String phoneNo, String fio, String status);
    List<Payment> getAllPayments();

}
