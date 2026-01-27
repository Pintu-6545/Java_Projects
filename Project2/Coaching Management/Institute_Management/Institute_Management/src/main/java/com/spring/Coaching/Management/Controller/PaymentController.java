package com.spring.Coaching.Management.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.Coaching.Management.Entity.Payment;
import com.spring.Coaching.Management.Service.PaymentService;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService service;

    public PaymentController(PaymentService service) {
        this.service = service;
    }

    // MAKE PAYMENT
    @PostMapping
    public Payment makePayment(@RequestBody Payment payment) {
        return service.makePayment(payment);
    }

    // UPDATE PAYMENT
    @PutMapping("/{id}")
    public Payment updatePayment(
            @PathVariable Long id,
            @RequestBody Payment payment) {
        return service.updatePayment(id, payment);
    }

    // GET ALL PAYMENTS
    @GetMapping
    public List<Payment> getAll() {
        return service.getAllPayments();
    }

    // GET PAYMENT BY ID
    @GetMapping("/{id}")
    public Payment getById(@PathVariable Long id) {
        return service.getPaymentById(id);
    }

    // DELETE PAYMENT
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deletePayment(id);
        return "Payment deleted successfully";
    }
}