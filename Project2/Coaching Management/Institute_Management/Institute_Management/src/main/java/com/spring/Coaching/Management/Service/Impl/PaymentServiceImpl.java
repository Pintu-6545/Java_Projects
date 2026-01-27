package com.spring.Coaching.Management.Service.Impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.Coaching.Management.Entity.Payment;
import com.spring.Coaching.Management.Repository.PaymentRepository;
import com.spring.Coaching.Management.Service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository repository;

    public PaymentServiceImpl(PaymentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Payment makePayment(Payment payment) {

        // Auto set fields (real-world)
        payment.setPaymentDate(LocalDateTime.now());
        payment.setStatus("SUCCESS");

        return repository.save(payment);
    }

    @Override
    public Payment updatePayment(Long id, Payment updated) {

        Payment existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found with id: " + id));

        existing.setAmount(updated.getAmount());
        existing.setPaymentMode(updated.getPaymentMode());
        existing.setStatus(updated.getStatus());
        existing.setStudent(updated.getStudent());
        existing.setBatch(updated.getBatch());

        return repository.save(existing);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found"));
    }

    @Override
    public List<Payment> getAllPayments() {
        return repository.findAll();
    }

    @Override
    public void deletePayment(Long id) {
        repository.deleteById(id);
    }
}