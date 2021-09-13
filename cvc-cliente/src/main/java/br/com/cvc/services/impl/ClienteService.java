package br.com.cvc.services.impl;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cvc.config.exceptions.DataIntegrityException;
import br.com.cvc.config.exceptions.ObjectNotFoundException;
import br.com.cvc.dto.EmailDTO;
import br.com.cvc.entities.Cliente;
import br.com.cvc.entities.dto.PacotesViagens;
import br.com.cvc.gateway.PacotesViagensGateway;
import br.com.cvc.gateway.RabbitmqGateway;
import br.com.cvc.repositories.ClienteRepository;
import br.com.cvc.services.IClienteService;

@Service
public class ClienteService implements IClienteService {
	
	private static final Logger LOGGER = Logger.getLogger(ClienteService.class.getName());

	
	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	private PacotesViagensGateway pacotesGateway;
	
	@Autowired
	private RabbitmqGateway rabbitmqGateway;

	@Override
	public Cliente save(Cliente obj) {
	    try {
		    LOGGER.info("Salvando cliente=["+obj+"]");	
			return repository.save(obj);
		}catch (Exception e) {
			LOGGER.severe("Error ao salvar cliente=["+obj+"] e=["+e.getMessage()+"]");	
			throw new DataIntegrityException("Não foi possivel inserir Cliente"); 
		}
		
	}

	@Override
	public Cliente updateById(Long id, Cliente obj) {
		var objBanc = this.getById(id);
		LOGGER.info("Alterando clientBanc=["+objBanc+"] e clienteNew=["+obj+"]");
		if(objBanc != null) {
			objBanc.setEmail(obj.getEmail());
			objBanc.setNome(obj.getNome());
		}
		LOGGER.info("Modificado informação dos atributos clientBanc=["+objBanc+"]");	
		return this.save(objBanc);
	}

	@Override
	public void deleteById(Long id) {
		var obj =this.getById(id);
		LOGGER.info("Deletando cliente=["+obj+"]");
		repository.deleteById(id);
	}

	@Override
	public Cliente getById(Long id) {
		LOGGER.info("Procurando cliente=["+id+"]");
		return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Não foi encontrado cliente com ID: "+id));
	}

	@Override
	public List<Cliente> findAll() {
		var list = repository.findAll();
		LOGGER.info("List de clientes=["+list.size()+"]");
		return list;
	}

	@Override
	public List<PacotesViagens> findAllPacotesFinalizados(Long id) {

		var cliente = this.getById(id);
		
		LOGGER.info("Lista de Pacotes de viagm para cliente=["+id+"]");
		var listPacotesViagensFinalizadosPorData = pacotesGateway.findAllPacottesViagensByDataFim(id, ZonedDateTime.now());

		//-> Filtrar os pacotes de viagens que tiverem questionario
		
		var listEmailsMandar = listPacotesViagensFinalizadosPorData
				.stream()
				.map(obj -> new EmailDTO(cliente.getIdCliente(), obj.getIdPacoteViagem(), 1L, cliente.getEmail(), cliente.getNome()))
				.collect(Collectors.toList());
		
		LOGGER.info("Lista de viagens para mandar disparar email ao cliente ["+cliente.getNome()+"] qtd pacotes=["+listEmailsMandar.size()+"]");
		
		// -> chamar Api para mandar email por pacote de viagem
		rabbitmqGateway.save(listEmailsMandar);
		
		return listPacotesViagensFinalizadosPorData;
	}

}
