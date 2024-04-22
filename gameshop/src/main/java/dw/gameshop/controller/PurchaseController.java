package dw.gameshop.controller;

import dw.gameshop.model.Purchase;
import dw.gameshop.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PurchaseController {
    @Autowired
    PurchaseService purchaseService;

    @PostMapping("/products/purchase")
    public Purchase savePurchase(@RequestBody Purchase purchase){
        return purchaseService.savePurchase(purchase);
    }

    @GetMapping("/products/purchase")
    public List<Purchase> getAllpurchases(){
        return purchaseService.getAllpurchases();
    }

    @GetMapping("/products/purchase/{userId}")
    public List<Purchase> getPurchaseListById(@PathVariable String userId) {
        return purchaseService.getPurchaseListByUser(userId);
    }

    @GetMapping("/products/purchase/name/{userName}")
    public ResponseEntity <List<Purchase>> getPurchaseListByUserName(
            @PathVariable String userName
    ) {
        return new ResponseEntity<>(purchaseService.getPurchaseListByUserName(userName), HttpStatus.OK);
    }
}
