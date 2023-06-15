package com.lkus.loyalty.purchase.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public record Purchase(String reference, String customer, LocalDate date, BigDecimal amount) {

    @Override
    public String toString() {
        return "{" +
                "id=" + reference +
                "|" + customer +
                "|" + date +
                "|$" + amount +
                '}';
    }
}
