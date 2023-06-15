package com.lkus.loyalty.points;

import com.lkus.loyalty.purchase.model.Month;

import java.time.LocalDate;

@FunctionalInterface
public interface Date2MonthConverter {
    Month getMonth(LocalDate d);
}
