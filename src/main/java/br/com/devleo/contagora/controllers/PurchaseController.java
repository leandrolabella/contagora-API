package br.com.devleo.contagora.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.devleo.contagora.domain.Purchase;
import br.com.devleo.contagora.dto.PurchaseDTO;
import br.com.devleo.contagora.services.PurchaseService;

@RestController
@RequestMapping(path = "api/v1/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @PostMapping
    public ResponseEntity<Purchase> savePurchase(@RequestBody PurchaseDTO purchase) {
        Purchase newpurchase = purchaseService.savePurchase(purchase);
        return new ResponseEntity<>(newpurchase, HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping(path = "/{card_id}")
    public ResponseEntity<List<Purchase>> getPurchase(@PathVariable("card_id") Long id) {
        List<Purchase> purchaseList = purchaseService.getPurchases(id);
        return new ResponseEntity<>(purchaseList, HttpStatus.OK);
    }
}
