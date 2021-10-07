package br.com.cvc.services;

import java.util.List;

import br.com.cvc.entities.Viagem;

public interface IViagemService {
	
	public Viagem save (Viagem obj);
	
	public Viagem updateById (Long id, Viagem obj);
	
	public void deleteById (Long id);
	
	public Viagem getById (Long id);
	
	public List<Viagem> findAll();
	
	
}
