package org.khail.paymentservice.Service;

import org.khail.paymentservice.Entitie.Payment;

import java.util.List;

public interface PaymentService {
    public List<Payment> getAllPayments();
    public Payment getPaymentById(int id);
    public Payment addPayment(Payment payment);
}
