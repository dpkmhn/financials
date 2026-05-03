package com.acme.accounting.dto;

import com.acme.accounting.entity.InvoiceStatus;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Requests {
  public record CreateCustomerRequest(@NotBlank String name, @Email String email, @NotBlank String currency, @NotBlank String paymentTerms) {}
  public record CreateInvoiceRequest(@NotBlank String customerName, @NotBlank String invoiceNumber, @NotNull @DecimalMin("0.01") BigDecimal amount, @NotNull LocalDate issueDate, @NotNull LocalDate dueDate, @NotNull InvoiceStatus status) {}
  public record CreateBillRequest(@NotBlank String vendor, @NotBlank String billNumber, @NotNull @DecimalMin("0.01") BigDecimal amount, @NotNull LocalDate dueDate, boolean paid) {}
}
