package org.khail.paymentservice.Web;

import org.khail.paymentservice.Entitie.Payment;
import org.khail.paymentservice.Service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PaymentWeb {
    private final PaymentService paymentService;

    public PaymentWeb(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/payment")
    public List<Payment> getPayments(){
        return paymentService.getAllPayments();
    }

    @GetMapping("/payment/{id}")
    public Payment getPaymentById(int id){
        return paymentService.getPaymentById(id);
    }

    @PostMapping("/payment")
    public Payment addPayment(Payment payment){
        return paymentService.addPayment(payment);
    }
}
