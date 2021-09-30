package br.com.cvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cvc.entities.Resposta;

@Repository
public interface RespostaRepository extends JpaRepository<Resposta, Long> {

}
