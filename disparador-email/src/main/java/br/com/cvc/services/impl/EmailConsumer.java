package br.com.cvc.services.impl;

import java.util.logging.Logger;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Component;

import br.com.cvc.dto.EmailDTO;
import br.com.cvc.services.EmailService;

@Component
public class EmailConsumer {

    @Autowired
    EmailService emailService;
	
	private static final Logger LOGGER = Logger.getLogger(EmailConsumer.class.getName());
	
	@RabbitListener(queues = "EMAIL")
	private void consumidor(EmailDTO dto) {
		try {
			String urlFake = "https://cvc.com.br/"+dto.getIdCliente()+"/"+dto.getIdPacoteViagem()+"/"+dto.getIdAvaliacao();
        	LOGGER.info("-> Enviando email: ["+dto.getEmail()+"]...");
        	emailService.sendSimpleEmail(dto.getEmail(), dto.getNome()+ " Link para Avaliação",urlFake);
        	LOGGER.info("-> Email enviado: ["+dto.getEmail()+"]");
        } catch (MailException mailException) {
        	LOGGER.info("-> Erro ao enviar Email: ["+dto.getEmail()+"] e: "+mailException.getMessage());
        	throw new InternalError("Erro interno ao enviar email");
        }
	
	}
}


