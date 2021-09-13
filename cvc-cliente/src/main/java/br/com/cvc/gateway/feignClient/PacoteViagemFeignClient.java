package br.com.cvc.gateway.feignClient;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.cvc.entities.dto.PacotesViagens;

@Component
@FeignClient(name = "cvc-viagens", path = "/pacoteViagens")
public interface PacoteViagemFeignClient {
	
	@GetMapping(path = "/cliente/{idCliente}")
	List<PacotesViagens> findAllPacoteViagemByDataFim(
			@PathVariable("idCliente") Long idCliente,
			@RequestParam("dataFim") @DateTimeFormat(iso = ISO.DATE_TIME) ZonedDateTime dataFim);

}
