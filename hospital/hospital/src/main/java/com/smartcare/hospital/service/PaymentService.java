package com.smartcare.hospital.service;

import java.math.BigDecimal;

public interface PaymentService {
    // polymorphic method every payment type must implement
    String processPayment(BigDecimal amount);
}