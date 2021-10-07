package br.com.cvc.config;

import javax.annotation.PostConstruct;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Binding.DestinationType;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConnection {
	
	@Autowired
    private Environment env;

	@Autowired
	private AmqpAdmin amqpAdmin;
	
	public RabbitMQConnection(AmqpAdmin amqpAdmin) {
		this.amqpAdmin = amqpAdmin; 
	}

	private Queue fila(String nomeFila) {
		return new Queue(nomeFila,true,false,false);
	}
	
	private DirectExchange trocaDireta() {
		return new DirectExchange(env.getProperty("rabbimq.exchance"));
	}
	
	private Binding relacionameto(Queue fila, DirectExchange troca) {
		return new Binding(fila.getName(),DestinationType.QUEUE,troca.getName(),fila.getName(),null);
	}
	
	@PostConstruct
	private void adiciona() {
		var fila_Email = this.fila(env.getProperty("rabbimq.queue"));
		var troca = this.trocaDireta();
		
		var ligacao = this.relacionameto(fila_Email, troca);
		
		this.amqpAdmin.declareQueue(fila_Email);
		this.amqpAdmin.declareExchange(troca);
		this.amqpAdmin.declareBinding(ligacao);
	}
	
}
