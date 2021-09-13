package br.com.cvc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.cvc.entities.ClientePacoteViagem;
import br.com.cvc.entities.ClientePacoteViagemId;

@Repository
public interface ClientePacoteViagemRepository extends JpaRepository<ClientePacoteViagem, ClientePacoteViagemId> {

	
	@Transactional(readOnly = true)
	@Query("SELECT cpv FROM ClientePacoteViagem cpv "
			+ "WHERE cpv.id.pacoteViagem.idPacoteViagem = :idPacoteViagem ")
	List<ClientePacoteViagem> findAllByPacoteViagem(Long idPacoteViagem);

}
