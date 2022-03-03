package com.fbayhan.customer;

public record CustomerRequest(
        String firstName,
        String lastName,
        String email
) {
}
