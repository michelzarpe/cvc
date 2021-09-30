package br.com.cvc.repositories;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.cvc.entities.PacoteViagem;

@Repository
public interface PacoteViagemRepository extends JpaRepository<PacoteViagem, Long> {

	@Transactional(readOnly = true)
	@Query("SELECT pv FROM PacoteViagem pv "
			+ "INNER JOIN pv.clientePacoteViagems cpv "
			+ "WHERE pv.dataFim < :dataFim AND cpv.id.idCliente = :idCliente ")
	List<PacoteViagem> findAllPacoteViagemByDataFimAndCliente(@Param("idCliente") Long idCliente,@Param("dataFim") ZonedDateTime dataFim);

	/*
	   select * from pacote_viagem pv
	   inner join cliente_pacote_viagem cpv on cpv.id_pacote_viagem=pv.id_pacote_viagem
	   WHERE pv.DATA_FIM < '2021-09-04' and cpv.id_cliente = 4
	 * */
}
