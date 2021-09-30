package br.com.cvc.services;

import java.time.ZonedDateTime;
import java.util.List;

import br.com.cvc.entities.PacoteViagem;

public interface IPacoteViagemService {
	
	public PacoteViagem save (PacoteViagem obj);
	
	public PacoteViagem updateById (Long id, PacoteViagem obj);
	
	public void deleteById (Long id);
	
	public PacoteViagem getById (Long id);
	
	public List<PacoteViagem> findAll();

	public List<PacoteViagem> findAllPacoteViagemByDataFimAndCliente(Long idCliente, ZonedDateTime dataFim);
	
	
}
