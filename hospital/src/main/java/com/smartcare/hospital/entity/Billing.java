package com.smartcare.hospital.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "Billing")
public class Billing {

    @Id
    @Column(name = "Bill_ID")
    private int billId;

    @Column(name = "Bill_Date")
    private Date billDate;

    @Column(name = "TotalAmount")
    private BigDecimal totalAmount;

    @Column(name = "PaymentStatus")
    private String paymentStatus;

    @Column(name = "PaymentMethod")
    private String paymentMethod;

    @Column(name = "Pa_ID")
    private int paId;



    // Getters and Setters

    public int getBillId() {
        return billId;
    }
    public void setBillId(int billId) {
        this.billId = billId;
    }

    public Date getBillDate() {
        return billDate;
    }
    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }
    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public int getPaId() {
        return paId;
    }
    public void setPaId(int paId) {
        this.paId = paId;
    }

}