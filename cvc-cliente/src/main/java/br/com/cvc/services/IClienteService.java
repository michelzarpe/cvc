package br.com.cvc.services;

import java.util.List;

import br.com.cvc.entities.Cliente;
import br.com.cvc.entities.dto.PacotesViagens;

public interface IClienteService {
	
	public Cliente save (Cliente obj);
	
	public Cliente updateById (Long id, Cliente obj);
	
	public void deleteById (Long id);
	
	public Cliente getById (Long id);
	
	public List<Cliente> findAll();
	
	public List<PacotesViagens> findAllPacotesFinalizados(Long idCliente);
	
}
