package org.khail.paymentservice.Service;

import jakarta.transaction.Transactional;
import org.khail.paymentservice.Entitie.Payment;
import org.khail.paymentservice.Repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {
    private PaymentRepository paymentRepository;
    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }
    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment getPaymentById(int id) {
        return paymentRepository.findById(id).orElse(null);
    }

    @Override
    public Payment addPayment(Payment payment) {
        return paymentRepository.save(payment);
    }
}
