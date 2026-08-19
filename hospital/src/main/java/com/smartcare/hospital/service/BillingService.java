package com.smartcare.hospital.service;

import com.smartcare.hospital.entity.Billing;
import com.smartcare.hospital.repository.BillingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class BillingService {

    @Autowired
    private BillingRepository billingRepository;

    // Spring Boot automatically injects our Cash, Card, and Online classes into this Map!
    @Autowired
    private Map<String, PaymentService> paymentMethods;

    public Billing payBill(Billing billing) {

        if (billing.getTotalAmount().compareTo(java.math.BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Bill amounts cannot be negative.");
        }
        // 1. Polymorphism in action: Fetch the correct payment class based on the String provided (e.g., "Cash")
        PaymentService selectedPaymentMethod = paymentMethods.get(billing.getPaymentMethod());

        if (selectedPaymentMethod == null) {
            throw new IllegalArgumentException("Invalid Payment Method: " + billing.getPaymentMethod());
        }

        // 2. Execute the specific payment logic
        String receipt = selectedPaymentMethod.processPayment(billing.getTotalAmount());
        System.out.println(receipt); // Prints to your IDE console to prove it worked

        // 3. Update status and save to database
        billing.setPaymentStatus("Paid");
        return billingRepository.save(billing);
    }

    public List<Billing> getAllBills() {
        return billingRepository.findAll();
    }
}