package org.khail.paymentservice.Repository;

import org.khail.paymentservice.Entitie.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment ,Integer> {
}
