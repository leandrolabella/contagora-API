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

import br.com.devleo.contagora.domain.cards.Card;
import br.com.devleo.contagora.dto.CardDTO;
import br.com.devleo.contagora.services.CardService;

@RestController
@RequestMapping(path = "api/v1/card")
public class CardController {

    @Autowired
    private CardService cardService;

    @PostMapping
    public ResponseEntity<Card> saveCard(@RequestBody CardDTO card) {
        Card newcard = cardService.saveCard(card);
        return new ResponseEntity<>(newcard, HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping(path = "/{user_id}")
    public ResponseEntity<List<Card>> getCardsByUser(@PathVariable("user_id") Long id) {
        List<Card> cardList = cardService.getUserCards(id);
        return new ResponseEntity<>(cardList, HttpStatus.OK);
    }
}
