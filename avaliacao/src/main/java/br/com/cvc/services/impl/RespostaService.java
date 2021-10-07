package br.com.cvc.services.impl;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cvc.config.exceptions.DataIntegrityException;
import br.com.cvc.config.exceptions.ObjectNotFoundException;
import br.com.cvc.entities.Resposta;
import br.com.cvc.repositories.RespostaRepository;
import br.com.cvc.services.IRespostaService;

@Service
public class RespostaService implements IRespostaService {
	
	private static final Logger LOGGER = Logger.getLogger(RespostaService.class.getName());

	
	@Autowired
	private RespostaRepository repository;
	
	@Override
	public Resposta save(Resposta obj) {
	    try {
		    LOGGER.info("Salvando Resposta=["+obj+"]");	
			return repository.save(obj);
		}catch (Exception e) {
			LOGGER.severe("Error ao salvar Resposta=["+obj+"] e=["+e.getMessage()+"]");	
			throw new DataIntegrityException("Não foi possivel inserir Resposta"); 
		}
		
	}

	@Override
	public Resposta updateById(Long id, Resposta obj) {
		var objBanc = this.getById(id);
		LOGGER.info("Alterando RespostaBanc=["+objBanc+"] e RespostaNew=["+obj+"]");
		if(objBanc != null) {
			objBanc.setAvaliacaoPergunta(obj.getAvaliacaoPergunta());
			objBanc.setIdCliente(obj.getIdCliente());
			objBanc.setNota(obj.getNota());
		}
		LOGGER.info("Modificado informação dos atributos RespostaBanc=["+objBanc+"]");	
		return this.save(objBanc);
	}

	@Override
	public void deleteById(Long id) {
		var obj =this.getById(id);
		try {
			LOGGER.info("Deletando Resposta=["+obj+"]");
			repository.deleteById(id);
		} catch (Exception e) {
			throw new DataIntegrityException("Existe registros filhos com esse objeto");
		}
	
	}

	@Override
	public Resposta getById(Long id) {
		LOGGER.info("Procurando Resposta=["+id+"]");
		return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Não foi encontrado Resposta com ID: "+id));
	}

	@Override
	public List<Resposta> findAll() {
		var list = repository.findAll();
		LOGGER.info("List de Respostas=["+list.size()+"]");
		return list;
	}
}
