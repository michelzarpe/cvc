package br.com.cvc.mapper;

import br.com.cvc.entities.Cliente;
import br.com.cvc.entities.dto.ClienteDTO;

public class Mappers {

	public static Cliente getClient (ClienteDTO objDto) {
		return new Cliente(null, objDto.getNome(), objDto.getEmail());
	}
}
