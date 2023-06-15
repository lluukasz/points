package com.lkus.loyalty.purchase;

import com.lkus.loyalty.purchase.model.Purchase;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * This class is for testing purposes only and shall be removed.
 * It feeds the Store with some fake data on bean initialization.
 */
@Configuration
public class TestDataInitializer {
    @Bean
    CommandLineRunner initStorage(Store testData) {
        return args -> {
            testData.addPurchase(new Purchase(Ref.next(), Cust.A, Day.get(), BigDecimal.valueOf(119.99)));
            testData.addPurchase(new Purchase(Ref.next(), Cust.B, Day.get(), BigDecimal.valueOf(109.99)));
            testData.addPurchase(new Purchase(Ref.next(), Cust.C, Day.get(), BigDecimal.valueOf(100)));
            testData.addPurchase(new Purchase(Ref.next(), Cust.D, Day.get(), BigDecimal.valueOf(19.99)));
            Day.step();
            testData.addPurchase(new Purchase(Ref.next(), Cust.B, Day.get(), BigDecimal.valueOf(80)));
            testData.addPurchase(new Purchase(Ref.next(), Cust.C, Day.get(), BigDecimal.valueOf(75.75)));
            Day.step();
            testData.addPurchase(new Purchase(Ref.next(), Cust.A, Day.get(), BigDecimal.valueOf(49.00)));
            testData.addPurchase(new Purchase(Ref.next(), Cust.C, Day.get(), BigDecimal.valueOf(40)));
            testData.addPurchase(new Purchase(Ref.next(), Cust.D, Day.get(), BigDecimal.valueOf(89)));
            Day.step();
            testData.addPurchase(new Purchase(Ref.next(), Cust.B, Day.get(), BigDecimal.valueOf(10)));
            testData.addPurchase(new Purchase(Ref.next(), Cust.D, Day.get(), BigDecimal.valueOf(70)));
            testData.addPurchase(new Purchase(Ref.next(), Cust.D, Day.get(), BigDecimal.valueOf(80)));
            Day.step();
            testData.addPurchase(new Purchase(Ref.next(), Cust.A, Day.get(), BigDecimal.valueOf(111)));
            testData.addPurchase(new Purchase(Ref.next(), Cust.A, Day.get(), BigDecimal.valueOf(99)));
            testData.addPurchase(new Purchase(Ref.next(), Cust.B, Day.get(), BigDecimal.valueOf(90)));

            System.out.println("Initialized with test data: " + testData.getData());
        };
    }

    static class Ref {
        static int id = 0;
        static String next() {
            return Integer.valueOf(++id).toString();
        }
    }

    static class Cust {
        static String A = "zenek";
        static String B = "xoxo";
        static String C = "1234";
        static String D = "aaaaa";
    }

    static class Day {
        static LocalDate day = LocalDate.of(2023, 6, 29);
        static LocalDate get() {
            return LocalDate.from(day);
        }
        static void step() {
            day = day.plusDays(1);
        }
    }
}