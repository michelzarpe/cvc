package br.com.cvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cvc.entities.Pergunta;

@Repository
public interface PerguntaRepository extends JpaRepository<Pergunta, Long> {

}
