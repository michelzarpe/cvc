package br.com.cvc.services.impl;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cvc.config.exceptions.DataIntegrityException;
import br.com.cvc.config.exceptions.ObjectNotFoundException;
import br.com.cvc.entities.Pergunta;
import br.com.cvc.repositories.PerguntaRepository;
import br.com.cvc.services.IPerguntaService;

@Service
public class PerguntaService implements IPerguntaService {
	
	private static final Logger LOGGER = Logger.getLogger(PerguntaService.class.getName());

	
	@Autowired
	private PerguntaRepository repository;
	
	@Override
	public Pergunta save(Pergunta obj) {
	    try {
		    LOGGER.info("Salvando Pergunta=["+obj+"]");	
			return repository.save(obj);
		}catch (Exception e) {
			LOGGER.severe("Error ao salvar Pergunta=["+obj+"] e=["+e.getMessage()+"]");	
			throw new DataIntegrityException("Não foi possivel inserir Pergunta"); 
		}
		
	}

	@Override
	public Pergunta updateById(Long id, Pergunta obj) {
		var objBanc = this.getById(id);
		LOGGER.info("Alterando PerguntaBanc=["+objBanc+"] e PerguntaNew=["+obj+"]");
		if(objBanc != null) {
			objBanc.setDescricao(obj.getDescricao());
		}
		LOGGER.info("Modificado informação dos atributos perguntaBanc=["+objBanc+"]");	
		return this.save(objBanc);
	}

	@Override
	public void deleteById(Long id) {
		var obj =this.getById(id);
		try {
		LOGGER.info("Deletando pergunta=["+obj+"]");
		repository.deleteById(id);
		} catch (Exception e) {
			throw new DataIntegrityException("Existe registros filhos com esse objeto");
		}
	}

	@Override
	public Pergunta getById(Long id) {
		LOGGER.info("Procurando pergunta=["+id+"]");
		return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Não foi encontrado pergunta com ID: "+id));
	}

	@Override
	public List<Pergunta> findAll() {
		var list = repository.findAll();
		LOGGER.info("List de perguntas=["+list.size()+"]");
		return list;
	}
}
