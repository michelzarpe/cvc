package br.com.cvc.gateway;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.cvc.dto.EmailDTO;
import br.com.cvc.gateway.feignClient.RabbitmqFeignClient;

@Component
public class RabbitmqGateway {

	private static final Logger LOGGER = Logger.getLogger(RabbitmqGateway.class.getName());

	@Autowired
	private RabbitmqFeignClient client;
	
	
	public void save(List<EmailDTO> objsDto) {
		LOGGER.info("Enviando para a mensageria quantidade de =["+objsDto.size()+"]");
		try {
			client.save(objsDto);	
		}catch (Exception e) {
			throw new InternalError("Error para enviar a mensageria");
		}
		
	}

}
