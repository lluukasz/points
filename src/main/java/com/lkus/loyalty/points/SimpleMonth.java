package com.lkus.loyalty.points;

import com.lkus.loyalty.purchase.model.Month;

import java.time.LocalDate;

public class SimpleMonth implements Date2MonthConverter {
    @Override
    public Month getMonth(LocalDate d) {
        return new Month(d.getYear(), d.getMonth().getValue());
    }
}
