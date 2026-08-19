package com.smartcare.hospital.service;

import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service("Card")
public class CardPayment implements PaymentService {
    @Override
    public String processPayment(BigDecimal amount) {
        // Custom logic for Card
        return "Connecting to card reader... Card payment of Rs. " + amount + " approved.";
    }
}