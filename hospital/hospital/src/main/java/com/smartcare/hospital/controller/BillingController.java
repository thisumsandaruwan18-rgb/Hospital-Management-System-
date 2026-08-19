package com.smartcare.hospital.controller;

import com.smartcare.hospital.entity.Billing;
import com.smartcare.hospital.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/billing")
public class BillingController {

    @Autowired
    private BillingService billingService;

    @PostMapping("/pay")
    public ResponseEntity<?> payBill(@RequestBody Billing billing) {
        try {
            Billing savedBill = billingService.payBill(billing);
            return ResponseEntity.ok(savedBill);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/all")
    public List<Billing> getAllBills() {
        return billingService.getAllBills();
    }
}