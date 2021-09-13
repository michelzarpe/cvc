package br.com.cvc.services;

import java.util.List;

import br.com.cvc.entities.ClientePacoteViagem;
import br.com.cvc.entities.ClientePacoteViagemId;

public interface IClientePacoteViagemService {
	
	public ClientePacoteViagem save (ClientePacoteViagem obj);
	
	public ClientePacoteViagem updateById (ClientePacoteViagemId id, ClientePacoteViagem obj);
	
	public void deleteById (ClientePacoteViagemId id);
	
	public ClientePacoteViagem getById (ClientePacoteViagemId id);
	
	public List<ClientePacoteViagem> findAll();

	public List<ClientePacoteViagem> findAllByPacoteViagem(Long idPacoteViagem);
	
	
}
