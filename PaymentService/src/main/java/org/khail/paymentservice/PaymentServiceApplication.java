package org.khail.paymentservice;

import org.khail.paymentservice.Entitie.Payment;
import org.khail.paymentservice.Entitie.PaymentMethod;
import org.khail.paymentservice.Repository.PaymentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.Date;

@SpringBootApplication
public class PaymentServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaymentServiceApplication.class, args);
    }
    @Bean
    public CommandLineRunner demo(PaymentRepository paymentRepository) {
        return args -> {
            Payment payment = new Payment();
            payment.setAmount(new BigDecimal("150.00"));
            payment.setPaymentMethod(PaymentMethod.CREDIT_CARD);
            payment.setOrderId(12345);
            payment.setCreatedDate(new Date());
            paymentRepository.save(payment);
            System.out.println("Payment saved: " + payment);
        };
    }
}
