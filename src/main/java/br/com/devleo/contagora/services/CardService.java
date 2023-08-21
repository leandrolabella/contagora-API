package br.com.devleo.contagora.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devleo.contagora.domain.User;
import br.com.devleo.contagora.domain.cards.Card;
import br.com.devleo.contagora.domain.cards.CardType;
import br.com.devleo.contagora.dto.CardDTO;
import br.com.devleo.contagora.repositories.CardRepository;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private UserService userService;

    public Card saveCard(CardDTO data){
        Card newcard = new Card();
        User user = userService.getUser(data.userId());

        newcard.setNickname(data.nickname());
        newcard.setUser(user);
        newcard.setCardType(CardType.valueOf(data.cardType()));
        cardRepository.save(newcard);
        return newcard;
    }

    public List<Card> getUserCards(Long userId){
        return cardRepository.findCardByUser_id(userId);
    }
}
