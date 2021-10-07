package br.com.cvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cvc.entities.AvaliacaoPergunta;

@Repository
public interface AvaliacaoPerguntaRepository extends JpaRepository<AvaliacaoPergunta, Long> {

}
