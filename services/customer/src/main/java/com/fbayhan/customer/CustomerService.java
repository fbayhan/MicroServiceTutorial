package com.fbayhan.customer;

import org.springframework.stereotype.Service;

@Service
public record CustomerService(CustomerRepository customerRepository) {
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

        customerRepository.save(customer);
    }
}
