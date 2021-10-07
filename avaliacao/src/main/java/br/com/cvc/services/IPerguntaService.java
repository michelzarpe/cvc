package br.com.cvc.services;

import java.util.List;

import br.com.cvc.entities.Pergunta;

public interface IPerguntaService {
	
	public Pergunta save (Pergunta obj);
	
	public Pergunta updateById (Long id, Pergunta obj);
	
	public void deleteById (Long id);
	
	public Pergunta getById (Long id);
	
	public List<Pergunta> findAll();

	
}
