package br.com.devleo.contagora.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.devleo.contagora.domain.cards.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Long>{

    List<Card> findCardByUser_id(Long id);
    
}
