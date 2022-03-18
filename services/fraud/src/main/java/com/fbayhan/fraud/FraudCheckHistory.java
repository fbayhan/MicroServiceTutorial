package com.fbayhan.fraud;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class FraudCheckHistory {

    @Id
    @SequenceGenerator(
            name = "customer_id_sequence",
            sequenceName = "fraud_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "fraud_id_sequence"
    )
    private Integer id;

    private  Integer customerId;
    private  Boolean isFraudster;
    private LocalDateTime createdAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Boolean getFraudster() {
        return isFraudster;
    }

    public void setFraudster(Boolean fraudster) {
        isFraudster = fraudster;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "FraudCheckHistory{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", isFraudster=" + isFraudster +
                ", createdAt=" + createdAt +
                '}';
    }
}
