package br.com.cvc.services.impl;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cvc.config.exceptions.DataIntegrityException;
import br.com.cvc.config.exceptions.ObjectNotFoundException;
import br.com.cvc.entities.ClientePacoteViagem;
import br.com.cvc.entities.ClientePacoteViagemId;
import br.com.cvc.repositories.ClientePacoteViagemRepository;
import br.com.cvc.services.IClientePacoteViagemService;

@Service
public class ClientePacoteViagemService implements IClientePacoteViagemService {

	private static final Logger LOGGER = Logger.getLogger(ClientePacoteViagemService.class.getName());
	
	@Autowired
	private ClientePacoteViagemRepository repository;
	
	@Override
	public ClientePacoteViagem save(ClientePacoteViagem obj) {
	    try {
		    LOGGER.info("Salvando =["+obj+"]");	
			return repository.save(obj);
		}catch (Exception e) {
			LOGGER.severe("Error ao salvar=["+obj+"] e=["+e.getMessage()+"]");	
			throw new DataIntegrityException("Não foi possivel inserir"); 
		}
	}

	@Override
	public ClientePacoteViagem updateById(ClientePacoteViagemId id, ClientePacoteViagem obj) {
		var objBanc = this.getById(id);
		LOGGER.info("Deletando banc=["+objBanc+"] e New=["+obj+"]");
		this.deleteById(objBanc.getId());
		LOGGER.info("Salvando a nova informação dos atributos banc=["+objBanc+"]");	
		return this.save(objBanc);
	}

	@Override
	public void deleteById(ClientePacoteViagemId id) {
		var obj = this.getById(id);
		LOGGER.info("Deletando=["+obj+"]");
		repository.deleteById(id);
		
	}

	@Override
	public ClientePacoteViagem getById(ClientePacoteViagemId id) {
		LOGGER.info("Procurando=["+id+"]");
		return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Não foi encontrado com ID: "+id));

	}

	@Override
	public List<ClientePacoteViagem> findAll() {
		var list = repository.findAll();
		LOGGER.info("List=["+list.size()+"]");
		return list;
	}

	@Override
	public List<ClientePacoteViagem> findAllByPacoteViagem(Long idPacoteViagem) {
		return repository.findAllByPacoteViagem(idPacoteViagem);
	}
	
	

}
