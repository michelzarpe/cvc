package br.com.cvc.services;

import java.util.List;

import br.com.cvc.entities.Avaliacao;

public interface IAvaliacaoService {
	
	public Avaliacao save (Avaliacao obj);
	
	public Avaliacao updateById (Long id, Avaliacao obj);
	
	public void deleteById (Long id);
	
	public Avaliacao getById (Long id);
	
	public List<Avaliacao> findAll();

	
}
