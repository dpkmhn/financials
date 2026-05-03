package com.acme.accounting.invoice;

import com.acme.accounting.entity.InvoiceStatus;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record InvoiceRequest(@NotBlank String customerName, @NotBlank String invoiceNumber, @NotNull @DecimalMin("0.01") BigDecimal amount,
                             @NotNull LocalDate issueDate, @NotNull LocalDate dueDate, @NotNull InvoiceStatus status) {}
