package br.com.cvc.services.impl;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cvc.config.exceptions.DataIntegrityException;
import br.com.cvc.config.exceptions.ObjectNotFoundException;
import br.com.cvc.entities.Viagem;
import br.com.cvc.repositories.ViagemRepository;
import br.com.cvc.services.IViagemService;

@Service
public class ViagemService implements IViagemService {

	private static final Logger LOGGER = Logger.getLogger(ViagemService.class.getName());
	
	@Autowired
	private ViagemRepository repository;
	
	@Override
	public Viagem save(Viagem obj) {
	    try {
		    LOGGER.info("Salvando =["+obj+"]");	
			return repository.save(obj);
		}catch (Exception e) {
			LOGGER.severe("Error ao salvar=["+obj+"] e=["+e.getMessage()+"]");	
			throw new DataIntegrityException("Não foi possivel inserir"); 
		}
	}

	@Override
	public Viagem updateById(Long id, Viagem obj) {
		var objBanc = this.getById(id);
		LOGGER.info("Alterando banc=["+objBanc+"] e New=["+obj+"]");
		if(objBanc != null) {
			objBanc.setDescricao(obj.getDescricao());
		}
		LOGGER.info("Modificado informação dos atributos banc=["+objBanc+"]");	
		return this.save(objBanc);
	}

	@Override
	public void deleteById(Long id) {
		var obj =this.getById(id);
		LOGGER.info("Deletando=["+obj+"]");
		repository.deleteById(id);
		
	}

	@Override
	public Viagem getById(Long id) {
		LOGGER.info("Procurando=["+id+"]");
		return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Não foi encontrado com ID: "+id));

	}

	@Override
	public List<Viagem> findAll() {
		var list = repository.findAll();
		LOGGER.info("List=["+list.size()+"]");
		return list;
	}
	
	

}
