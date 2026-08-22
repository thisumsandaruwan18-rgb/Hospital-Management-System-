package com.smartcare.hospital.service;

import java.math.BigDecimal;

public interface PaymentService {

    String processPayment(BigDecimal amount);
}