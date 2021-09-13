package br.com.cvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cvc.entities.Anexo;

@Repository
public interface AnexoRepository extends JpaRepository<Anexo, Long> {

}
