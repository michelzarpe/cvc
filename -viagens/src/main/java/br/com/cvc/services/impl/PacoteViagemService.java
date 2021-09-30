package br.com.cvc.services.impl;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cvc.config.exceptions.DataIntegrityException;
import br.com.cvc.config.exceptions.ObjectNotFoundException;
import br.com.cvc.entities.ClientePacoteViagem;
import br.com.cvc.entities.PacoteViagem;
import br.com.cvc.repositories.PacoteViagemRepository;
import br.com.cvc.services.IClientePacoteViagemService;
import br.com.cvc.services.IPacoteViagemService;

@Service
public class PacoteViagemService implements IPacoteViagemService {

	private static final Logger LOGGER = Logger.getLogger(PacoteViagemService.class.getName());
	
	@Autowired
	private PacoteViagemRepository repository;
	
	@Autowired
	private IClientePacoteViagemService clientePacoteViagemService;
	
	@Override
	public PacoteViagem save(PacoteViagem obj) {
	    try {
		    LOGGER.info("Salvando =["+obj+"]");	
			return repository.save(obj);
		}catch (Exception e) {
			LOGGER.severe("Error ao salvar=["+obj+"] e=["+e.getMessage()+"]");	
			throw new DataIntegrityException("Não foi possivel inserir"); 
		}
	}

	@Override
	public PacoteViagem updateById(Long id, PacoteViagem obj) {
		var objBanc = this.getById(id);
		LOGGER.info("Alterando banc=["+objBanc+"] e New=["+obj+"]");
		if(objBanc != null) {
			objBanc.setDataFim(obj.getDataFim());
			objBanc.setDataInicio(obj.getDataInicio());
			objBanc.setIdAvaliacao(obj.getIdAvaliacao());
			objBanc.setViagem(obj.getViagem());
			objBanc.setDescricao(obj.getDescricao());

		}
		LOGGER.info("Modificado informação dos atributos banc=["+objBanc+"]");	
		return this.save(objBanc);
	}

	@Override
	public void deleteById(Long id) {
		var obj =this.getById(id);
		LOGGER.info("Deletando=["+obj+"]");
		try {
			List<ClientePacoteViagem> list = clientePacoteViagemService.findAllByPacoteViagem(obj.getIdPacoteViagem());
			list.forEach(t-> clientePacoteViagemService.deleteById(t.getId()));
			repository.deleteById(id);	
		} catch (Exception e) {
			LOGGER.info("Error ao deletar=["+obj+"]");
			throw new DataIntegrityException("Não foi possivel deletar"); 
			
		}
		
		
	}

	@Override
	public PacoteViagem getById(Long id) {
		LOGGER.info("Procurando=["+id+"]");
		return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Não foi encontrado com ID: "+id));

	}

	@Override
	public List<PacoteViagem> findAll() {
		var list = repository.findAll();
		LOGGER.info("List=["+list.size()+"]");
		return list;
	}

	@Override
	public List<PacoteViagem> findAllPacoteViagemByDataFimAndCliente(Long idCliente, ZonedDateTime dataFim) {
		return repository.findAllPacoteViagemByDataFimAndCliente(idCliente, dataFim);
	}
	
	

}
