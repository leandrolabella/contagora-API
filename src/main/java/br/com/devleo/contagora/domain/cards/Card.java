package br.com.devleo.contagora.domain.cards;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.devleo.contagora.domain.OtherPerson;
import br.com.devleo.contagora.domain.User;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="cards")
@Table(name="cards")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nickname;
    @ManyToOne
    @JoinColumn(name="user_id")
    @JsonIgnore
    private User user;
    @Enumerated(EnumType.STRING)
    private CardType cardType;
    @OneToMany
    @JoinColumn(name="card_id")
    private List<OtherPerson> otherPerson;
}
