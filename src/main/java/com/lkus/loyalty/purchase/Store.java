package com.lkus.loyalty.purchase;

import com.lkus.loyalty.purchase.model.Purchase;
import jakarta.annotation.Nullable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.TreeMap;

@Service
public class Store {
    TreeMap<String, Purchase> data = new TreeMap<>();

    public @Nullable Purchase getPurchase(String id) {
        return data.get(id);
    }

    public boolean replacePurchase(Purchase purchase) {
        if (null==data.get(purchase.reference()))
            return false;
        data.replace(purchase.reference(), purchase);
        return true;
    }
    public boolean addPurchase(Purchase purchase) {
        if (null!=data.get(purchase.reference()))
            return false;
        data.put(purchase.reference(), purchase);
        return true;
    }

    public boolean deletePurchase(String reference) {
        return (null==data.remove(reference));
    }

    public Collection<Purchase> getData() {
        return data.values();
    }
}
