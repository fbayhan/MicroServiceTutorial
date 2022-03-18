package com.fbayhan.fraud;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FraudCheckHistoryService {

    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    public FraudCheckHistoryService(FraudCheckHistoryRepository fraudCheckHistoryRepository) {
        this.fraudCheckHistoryRepository = fraudCheckHistoryRepository;

    }


    public boolean isFraudulentCustomer(Integer customerId){
        FraudCheckHistory fraudCheckHistory=new FraudCheckHistory();
        fraudCheckHistory.setCustomerId(customerId);
        fraudCheckHistory.setCreatedAt(LocalDateTime.now());
        fraudCheckHistory.setFraudster(false);
fraudCheckHistoryRepository.save(fraudCheckHistory);
        return  false;
    }


}
