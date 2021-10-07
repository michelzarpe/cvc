package br.com.cvc.gateway.feignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.cvc.dto.EmailDTO;

@Component
@FeignClient(name = "cvc-rabbitmq", path = "/rabbitmq")
public interface RabbitmqFeignClient {

	@PostMapping(path = "/listSend")
	public void save(@RequestBody List<EmailDTO> objsDto);
	
}
