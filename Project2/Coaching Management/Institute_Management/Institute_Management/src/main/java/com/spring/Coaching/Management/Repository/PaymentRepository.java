package com.spring.Coaching.Management.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.Coaching.Management.Entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
