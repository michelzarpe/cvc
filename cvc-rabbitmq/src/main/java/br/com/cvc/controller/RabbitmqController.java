package br.com.cvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.cvc.dto.EmailDTO;
import br.com.cvc.service.impl.RabbitmqServiceImp;

@RestController
@RequestMapping(value = "rabbitmq")
public class RabbitmqController {

	@Autowired
	private RabbitmqServiceImp rabbitmqService;
	
	@Autowired
    private Environment env;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void save(@RequestBody EmailDTO objDto) {
		rabbitmqService.sendMessage(env.getProperty("rabbimq.queue"), objDto);
	}
	
	@PostMapping(path = "/listSend")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void save(@RequestBody List<EmailDTO> objsDto) {
		rabbitmqService.sendMessage(env.getProperty("rabbimq.queue"), objsDto);
	}
}
