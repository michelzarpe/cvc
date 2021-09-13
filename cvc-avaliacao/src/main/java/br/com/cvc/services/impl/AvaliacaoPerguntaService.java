package br.com.cvc.services.impl;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cvc.config.exceptions.DataIntegrityException;
import br.com.cvc.config.exceptions.ObjectNotFoundException;
import br.com.cvc.entities.AvaliacaoPergunta;
import br.com.cvc.repositories.AvaliacaoPerguntaRepository;
import br.com.cvc.services.IAvaliacaoPerguntaService;

@Service
public class AvaliacaoPerguntaService implements IAvaliacaoPerguntaService {

	private static final Logger LOGGER = Logger.getLogger(AvaliacaoPerguntaService.class.getName());

	@Autowired
	private AvaliacaoPerguntaRepository repository;

	@Override
	public AvaliacaoPergunta save(AvaliacaoPergunta obj) {
		try {
			LOGGER.info("Salvando AvaliacaoPergunta=[" + obj + "]");
			return repository.save(obj);
		} catch (Exception e) {
			LOGGER.severe("Error ao salvar AvaliacaoPergunta=[" + obj + "] e=[" + e.getMessage() + "]");
			throw new DataIntegrityException("Não foi possivel inserir AvaliacaoPergunta");
		}

	}

	@Override
	public AvaliacaoPergunta updateById(Long id, AvaliacaoPergunta obj) {
		var objBanc = this.getById(id);
		LOGGER.info("Alterando AvaliacaoPerguntaBanc=[" + objBanc + "] e AvaliacaoPerguntaNew=[" + obj + "]");
		if (objBanc != null) {
			objBanc.setAvaliacao(obj.getAvaliacao());
			objBanc.setPergunta(obj.getPergunta());
		}
		LOGGER.info("Modificado informação dos atributos AvaliacaoPerguntaBanc=[" + objBanc + "]");
		return this.save(objBanc);
	}

	@Override
	public void deleteById(Long id) {
		var obj = this.getById(id);
		try {
			LOGGER.info("Deletando AvaliacaoPergunta=[" + obj + "]");
			repository.deleteById(id);
		} catch (Exception e) {
			throw new DataIntegrityException("Existe registros filhos com esse objeto");
		}
	}

	@Override
	public AvaliacaoPergunta getById(Long id) {
		LOGGER.info("Procurando AvaliacaoPergunta=[" + id + "]");
		return repository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Não foi encontrado AvaliacaoPergunta com ID: " + id));
	}

	@Override
	public List<AvaliacaoPergunta> findAll() {
		var list = repository.findAll();
		LOGGER.info("List de AvaliacaoPergunta=[" + list.size() + "]");
		return list;
	}
}
