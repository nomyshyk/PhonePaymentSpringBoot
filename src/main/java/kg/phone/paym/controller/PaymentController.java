package kg.phone.paym.controller;

import kg.phone.paym.model.Payment;
import kg.phone.paym.model.PaymentRequest;
import kg.phone.paym.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author kasiom
 */
@RestController
@RequestMapping("api/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    /*public PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }*/

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Payment addPayment(@RequestBody PaymentRequest p){

        return paymentService.save(p);
    }

    @GetMapping
    public List<Payment> getAllPayments(){
        return paymentService.getAllPayments();
    }

    @PutMapping("/confirm/{id}")
    public Payment confirmPayment(@PathVariable Long id){
        return paymentService.confirmPayment(id);
    }

    @GetMapping("/client/{id}")
    public List<Payment> getPaymentsOfClient(@PathVariable Long id){
        return paymentService.getAllPaymentsOfClient(id);
    }

    @GetMapping
            (params = {"phoneNo", "fio", "status"}, value = "/search")
    public List<Payment> getPaymentsByParams(
            @RequestParam(value = "phoneNo", required = false)String phoneNo,
            @RequestParam(value = "fio", required = false)String fio,
            @RequestParam(value = "status", required = false)String status
    ){
        return paymentService.getAllPaymByParams(phoneNo, fio, status);
    }

}
