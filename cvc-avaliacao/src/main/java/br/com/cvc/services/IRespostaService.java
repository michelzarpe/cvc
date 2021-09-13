package br.com.cvc.services;

import java.util.List;

import br.com.cvc.entities.Resposta;

public interface IRespostaService {
	
	public Resposta save (Resposta obj);
	
	public Resposta updateById (Long id, Resposta obj);
	
	public void deleteById (Long id);
	
	public Resposta getById (Long id);
	
	public List<Resposta> findAll();

	
}
