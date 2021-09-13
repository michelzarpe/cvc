package br.com.cvc.controller;

import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cvc.dto.EmailDTO;
import br.com.cvc.services.EmailService;

@RestController
@RequestMapping("/email")
public class EmailController {
	
	private static final Logger LOGGER = Logger.getLogger(EmailController.class.getName());

	@Autowired
	private Environment env;
	
    @Autowired
    EmailService emailService;

    @PostMapping(value = "/{user-email}")
    public ResponseEntity sendSimpleEmail(@PathVariable("user-email") String email,@Valid @RequestBody EmailDTO objDTO ) {

    	LOGGER.info("Buscando coniguração do servidor do git"+env.getProperty("rabbimq.queue"));
    	
    	
        try {
            emailService.sendSimpleEmail(email, "Link para Avaliação", objDTO.getNome());
        } catch (MailException mailException) {
        	LOGGER.info("Error ao enviar o email .."+ mailException.getMessage());
            return new ResponseEntity<>("Erro interno para enviar o email", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>("sucesso", HttpStatus.OK);
    }
}

