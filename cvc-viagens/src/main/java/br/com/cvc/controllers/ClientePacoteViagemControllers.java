package br.com.cvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.cvc.entities.ClientePacoteViagem;
import br.com.cvc.entities.dto.ClientePacoteViagemDTO;
import br.com.cvc.mapper.Mappers;
import br.com.cvc.services.IClientePacoteViagemService;

@RestController
@RequestMapping(value = "clientePacoteViagens")
public class ClientePacoteViagemControllers {

	@Autowired
	private IClientePacoteViagemService service;
	
	@Autowired
	private Mappers mappers;
	
	
	@GetMapping(path = "/findAll")
	public List<ClientePacoteViagem> findAll(){
		return service.findAll();
	}

	@GetMapping(path = "/cliente/{idCliente}/pacote/{idPacote}")
	public ClientePacoteViagem findById(@PathVariable("idCliente") Long idCliente, 
										@PathVariable("idPacote") Long idPacote){
		return service.getById(mappers.getClientePacoteViagemId(idCliente, idPacote));
	}
	
	@DeleteMapping(path = "/cliente/{idCliente}/pacote/{idPacote}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("idCliente") Long idCliente, 
					   @PathVariable("idPacote") Long idPacote) {
		service.deleteById(mappers.getClientePacoteViagemId(idCliente, idPacote));
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void save(@Valid @RequestBody ClientePacoteViagemDTO objDto) {
		service.save(mappers.getClientePacoteViagem(objDto));
	}
	
	@PutMapping(path = "/cliente/{idCliente}/pacote/{idPacote}")
	public ClientePacoteViagem update(@Valid @RequestBody ClientePacoteViagemDTO objDto,
				               @PathVariable("idCliente") Long idCliente, 
			                   @PathVariable("idPacote") Long idPacote) {
		return service.updateById(mappers.getClientePacoteViagemId(idCliente, idPacote),
				mappers.getClientePacoteViagem(objDto));
	}
}
