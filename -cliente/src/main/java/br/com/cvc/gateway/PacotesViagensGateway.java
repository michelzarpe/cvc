package br.com.cvc.gateway;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.cvc.config.exceptions.ObjectNotFoundException;
import br.com.cvc.entities.dto.PacotesViagens;
import br.com.cvc.gateway.feignClient.PacoteViagemFeignClient;

@Component
public class PacotesViagensGateway {

	private static final Logger LOGGER = Logger.getLogger(PacotesViagensGateway.class.getName());

	@Autowired
	private PacoteViagemFeignClient client;
	
	
	public List<PacotesViagens> findAllPacottesViagensByDataFim(Long id, ZonedDateTime now) {
		LOGGER.info(String.format("Retornando lista poacotes viagens para id=[%d] e data=["+now+"]", id));
		try {
			return client.findAllPacoteViagemByDataFim(id, now);
		}catch (Exception e) {
			throw new ObjectNotFoundException("Error ao trazer lista");
		}
		
	}

}
