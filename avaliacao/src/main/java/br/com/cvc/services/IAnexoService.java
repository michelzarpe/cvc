package br.com.cvc.services;

import java.util.List;

import br.com.cvc.entities.Anexo;

public interface IAnexoService {
	
	public Anexo save (Anexo obj);
	
	public Anexo updateById (Long id, Anexo obj);
	
	public void deleteById (Long id);
	
	public Anexo getById (Long id);
	
	public List<Anexo> findAll();

	
}
