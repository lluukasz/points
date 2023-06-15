package com.lkus.loyalty;

import com.lkus.loyalty.purchase.Store;
import com.lkus.loyalty.purchase.model.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
public class Controller {
    public static final ResponseEntity<?> OK = ResponseEntity.ok().build();
    public static final ResponseEntity<?> NF = ResponseEntity.notFound().build();
    @Autowired
    private Store store;

    @GetMapping("/purchase")
    public Collection<Purchase> getAll() {
        return store.getData();
    }

    @PostMapping("/purchase")
    public ResponseEntity<?> create(@RequestBody Purchase purchase) {
        // todo: error handling
        if (store.addPurchase(purchase))
            return OK;
        else
            return NF;

    }

    @GetMapping("/purchase/{reference}")
    public ResponseEntity<Purchase> read(@PathVariable String reference) {
        return Optional.ofNullable(store.getPurchase(reference))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/purchase")
    public ResponseEntity<?> update(@RequestBody Purchase purchase) {
        if (store.replacePurchase(purchase))
            return OK;
        else
            return NF;
    }

    @DeleteMapping("/purchase/{reference}")
    public ResponseEntity<?> delete(@PathVariable String reference) {
        if (store.deletePurchase(reference))
            return OK;
        else
            return NF;
    }

    // todo:
    /*
    @GetMapping("/points/{id}")
    public @ResponseBody Points getCustomerPoints(@PathVariable String id){
        return loyalty.getPoints(id);
    }
    @GetMapping("/report")
    public @ResponseBody Report getSummary(){
        // todo: what is the current month or past month
//        month = SimpleMonth::getMonth(LocalDate.now());
//        month = (LocalDate.now())->SimpleMonth::getMonth;
        return loyalty.getReport(new Month(2023, 7));
    }
    @GetMapping("/report/{month}")
    public @ResponseBody Report getSummary(@RequestParam(value="month")int month){
        // todo: validate input
        return loyalty.getReport(month);
    }
    */
}
