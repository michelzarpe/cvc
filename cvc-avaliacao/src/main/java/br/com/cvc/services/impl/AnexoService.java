package br.com.cvc.services.impl;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cvc.config.exceptions.DataIntegrityException;
import br.com.cvc.config.exceptions.ObjectNotFoundException;
import br.com.cvc.entities.Anexo;
import br.com.cvc.repositories.AnexoRepository;
import br.com.cvc.services.IAnexoService;

@Service
public class AnexoService implements IAnexoService {

	private static final Logger LOGGER = Logger.getLogger(AnexoService.class.getName());

	@Autowired
	private AnexoRepository repository;

	@Override
	public Anexo save(Anexo obj) {
		try {
			LOGGER.info("Salvando Anexo=[" + obj + "]");
			return repository.save(obj);
		} catch (Exception e) {
			LOGGER.severe("Error ao salvar Anexo=[" + obj + "] e=[" + e.getMessage() + "]");
			throw new DataIntegrityException("Não foi possivel inserir Anexo");
		}

	}

	@Override
	public Anexo updateById(Long id, Anexo obj) {
		var objBanc = this.getById(id);
		LOGGER.info("Alterando AnexoBanc=[" + objBanc + "] e AnexoNew=[" + obj + "]");
		if (objBanc != null) {
			objBanc.setArquivo(obj.getArquivo());
			objBanc.setAvaliacao(obj.getAvaliacao());
			objBanc.setIdCliente(obj.getIdCliente());
			objBanc.setType(obj.getType());
		}
		LOGGER.info("Modificado informação dos atributos AnexoBanc=[" + objBanc + "]");
		return this.save(objBanc);
	}

	@Override
	public void deleteById(Long id) {
		var obj = this.getById(id);
		try {
			LOGGER.info("Deletando Anexo=[" + obj + "]");
			repository.deleteById(id);
		} catch (Exception e) {
			throw new DataIntegrityException("Existe registros filhos com esse objeto");
		}
	}

	@Override
	public Anexo getById(Long id) {
		LOGGER.info("Procurando Anexo=[" + id + "]");
		return repository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Não foi encontrado Anexo com ID: " + id));
	}

	@Override
	public List<Anexo> findAll() {
		var list = repository.findAll();
		LOGGER.info("List de Anexos=[" + list.size() + "]");
		return list;
	}
}
