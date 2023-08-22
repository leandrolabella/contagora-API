package br.com.devleo.contagora.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devleo.contagora.domain.Purchase;
import br.com.devleo.contagora.domain.cards.Card;
import br.com.devleo.contagora.dto.PurchaseDTO;
import br.com.devleo.contagora.repositories.PurchaseRepository;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private CardService cardService;

    public Purchase savePurchase(PurchaseDTO data) {
        Purchase purchase = new Purchase();
        Card card = cardService.getCard(data.card_id());
        purchase.setCard(card);
        purchase.setAmount(data.amount());
        purchase.setDescription(data.description());
        purchase.setHasInstallments(data.hasInstallments());
        purchase.setInstallments(data.installments());
        purchase.setTimestamp(LocalDateTime.now());
        purchaseRepository.save(purchase);
        return purchase;
    }

    public List<Purchase> getPurchases(Long id) {
        List<Purchase> purchases = purchaseRepository.findPurchaseByCard_id(id);
        return purchases;
    }

}
