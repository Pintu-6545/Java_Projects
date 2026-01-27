package com.spring.Coaching.Management.Service;

import java.util.List;

import com.spring.Coaching.Management.Entity.Payment;

public interface PaymentService {

	Payment makePayment(Payment payment);

    Payment updatePayment(Long id, Payment payment);

    Payment getPaymentById(Long id);

    List<Payment> getAllPayments();

    void deletePayment(Long id);
}
