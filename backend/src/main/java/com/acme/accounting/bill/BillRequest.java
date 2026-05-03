package com.acme.accounting.bill;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record BillRequest(@NotBlank String vendor, @NotBlank String billNumber, @NotNull @DecimalMin("0.01") BigDecimal amount, @NotNull LocalDate dueDate, boolean paid) {}
