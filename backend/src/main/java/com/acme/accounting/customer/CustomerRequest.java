package com.acme.accounting.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CustomerRequest(@NotBlank String name, @Email String email, @NotBlank String currency, @NotBlank String paymentTerms) {}
