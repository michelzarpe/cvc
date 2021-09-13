package br.com.cvc.services;

import java.util.List;

import br.com.cvc.entities.AvaliacaoPergunta;

public interface IAvaliacaoPerguntaService {
	
	public AvaliacaoPergunta save (AvaliacaoPergunta obj);
	
	public AvaliacaoPergunta updateById (Long id, AvaliacaoPergunta obj);
	
	public void deleteById (Long id);
	
	public AvaliacaoPergunta getById (Long id);
	
	public List<AvaliacaoPergunta> findAll();
	
}
