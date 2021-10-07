package br.com.cvc.service;

import java.util.List;

import br.com.cvc.dto.EmailDTO;

public interface IRabbitmaService {

	public void sendMessage(String nomeFila, EmailDTO messagem);
	
	public void sendMessage(String nomeFila, List<EmailDTO> messagems);
}
