package com.fbayhan.fraud;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fraud-check")
public class FraudController {

    private  final  FraudCheckHistoryService fraudCheckHistoryService;

    public FraudController(FraudCheckHistoryService fraudCheckHistoryService) {
        this.fraudCheckHistoryService = fraudCheckHistoryService;
    }

    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerID){

        boolean isFraudulentCustomer= fraudCheckHistoryService.isFraudulentCustomer(customerID);

        System.out.println("fraud check request for customer " + customerID);

        return  new FraudCheckResponse(isFraudulentCustomer);
    }

}
