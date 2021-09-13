package br.com.cvc.services.impl;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cvc.config.exceptions.DataIntegrityException;
import br.com.cvc.config.exceptions.ObjectNotFoundException;
import br.com.cvc.entities.Avaliacao;
import br.com.cvc.repositories.AvaliacaoRepository;
import br.com.cvc.services.IAvaliacaoService;

@Service
public class AvaliacaoService implements IAvaliacaoService {

	private static final Logger LOGGER = Logger.getLogger(AvaliacaoService.class.getName());

	@Autowired
	private AvaliacaoRepository repository;

	@Override
	public Avaliacao save(Avaliacao obj) {
		try {
			LOGGER.info("Salvando Avaliacao=[" + obj + "]");
			return repository.save(obj);
		} catch (Exception e) {
			LOGGER.severe("Error ao salvar Avaliacao=[" + obj + "] e=[" + e.getMessage() + "]");
			throw new DataIntegrityException("Não foi possivel inserir Avaliacao");
		}

	}

	@Override
	public Avaliacao updateById(Long id, Avaliacao obj) {
		var objBanc = this.getById(id);
		LOGGER.info("Alterando AvaliacaoBanc=[" + objBanc + "] e AvaliacaoNew=[" + obj + "]");
		if (objBanc != null) {
			objBanc.setIdPacoteViagem(obj.getIdPacoteViagem());
			objBanc.setStatus(obj.getStatus());
		}
		LOGGER.info("Modificado informação dos atributos AvaliacaoBanc=[" + objBanc + "]");
		return this.save(objBanc);
	}

	@Override
	public void deleteById(Long id) {
		var obj = this.getById(id);
		try {
			LOGGER.info("Deletando Avaliacao=[" + obj + "]");
			repository.deleteById(id);
		} catch (Exception e) {
			throw new DataIntegrityException("Existe registros filhos com esse objeto");
		}
	}

	@Override
	public Avaliacao getById(Long id) {
		LOGGER.info("Procurando Avaliacao=[" + id + "]");
		return repository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Não foi encontrado Avaliacao com ID: " + id));
	}

	@Override
	public List<Avaliacao> findAll() {
		var list = repository.findAll();
		LOGGER.info("List de Avaliacao=[" + list.size() + "]");
		return list;
	}
}
