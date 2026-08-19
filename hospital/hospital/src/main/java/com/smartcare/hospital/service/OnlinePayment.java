package com.smartcare.hospital.service;

import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service("Online")
public class OnlinePayment implements PaymentService {
    @Override
    public String processPayment(BigDecimal amount) {
        // Custom logic for Online/Gateway
        return "Routing through secure payment gateway... Online payment of Rs. " + amount + " successful.";
    }
}