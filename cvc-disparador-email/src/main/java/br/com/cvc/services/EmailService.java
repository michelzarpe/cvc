package br.com.cvc.services;

public interface EmailService {
    
	public void sendSimpleEmail(String toAddress, String subject, String message);
}
