package com.fbayhan.customer;

import com.fbayhan.clients.fraud.FraudCheckResponse;
import com.fbayhan.clients.fraud.FraudClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;
    private final FraudClient fraudClient;

    public CustomerService(CustomerRepository customerRepository, RestTemplate restTemplate, FraudClient fraudClient) {
        this.customerRepository = customerRepository;
        this.restTemplate = restTemplate;
        this.fraudClient = fraudClient;
    }


    public void registerCustomer(CustomerRequest customerRequest) {

        /*
        Customer customer=Customer.builder()
                .firstName(customerRequest.firstName())
                .lastName(customerRequest.lastName())
                .email(customerRequest.email())
                .build();

         */

        Customer customer = new Customer();
        customer.setEmail(customerRequest.email());
        customer.setFirstName(customerRequest.firstName());
        customer.setLastName(customerRequest.lastName());

        customerRepository.saveAndFlush(customer);

        /*
        FraudCheckResponse fraudCheckResponse= restTemplate.getForObject(
                "http://FRAUD/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,
                customer.getId()
        );
*/
        FraudCheckResponse fraudCheckResponse=fraudClient.isFraudster(customer.getId());

        if(fraudCheckResponse.isFraudster()){
            throw new IllegalStateException("frauster");
        }

    }
}
