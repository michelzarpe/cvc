package br.com.cvc.service.impl;

import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cvc.dto.EmailDTO;
import br.com.cvc.service.IRabbitmaService;

@Service
public class RabbitmqServiceImp implements IRabbitmaService{

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public void sendMessage(String nomeFila, EmailDTO messagem) {
		this.rabbitTemplate.convertAndSend(nomeFila, messagem);
	}
	
	public void sendMessage(String nomeFila, List<EmailDTO> messagems) {
		messagems.stream().forEach(obj-> this.rabbitTemplate.convertAndSend(nomeFila, obj));
	}
	
}
