package br.com.devleo.contagora.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devleo.contagora.domain.OtherPerson;
import br.com.devleo.contagora.domain.cards.Card;
import br.com.devleo.contagora.dto.OtherPersonDTO;
import br.com.devleo.contagora.repositories.OtherPersonRepository;

@Service
public class OtherPersonService {

    @Autowired
    private OtherPersonRepository otherPersonRepository;

    @Autowired
    private CardService cardService;

    public Card saveOtherPerson(OtherPersonDTO data) {
        Card card = cardService.getCard(data.card_id());
        OtherPerson otherPerson = new OtherPerson();
        otherPerson.setName(data.name());
        otherPerson.setCard(null);
        otherPersonRepository.save(otherPerson);
        return card;
    }
}
