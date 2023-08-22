package br.com.devleo.contagora.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.devleo.contagora.domain.OtherPerson;

@Repository
public interface OtherPersonRepository extends JpaRepository<OtherPerson, Long>{
    
}
