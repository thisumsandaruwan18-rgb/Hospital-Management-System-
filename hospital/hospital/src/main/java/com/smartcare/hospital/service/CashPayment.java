package com.smartcare.hospital.service;

import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service("Cash")
public class CashPayment implements PaymentService {
    @Override
    public String processPayment(BigDecimal amount) {
        // Custom logic for Cash
        return "Processing physical Cash payment of Rs. " + amount + " at the front desk.";
    }
}