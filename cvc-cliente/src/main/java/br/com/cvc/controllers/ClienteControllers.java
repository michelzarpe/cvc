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

import br.com.cvc.entities.Cliente;
import br.com.cvc.entities.dto.ClienteDTO;
import br.com.cvc.entities.dto.PacotesViagens;
import br.com.cvc.mapper.Mappers;
import br.com.cvc.services.IClienteService;

@RestController
@RequestMapping(value = "clientes")
public class ClienteControllers {

	@Autowired
	private IClienteService clienteService;
	
	@GetMapping(path = "/findAll")
	public List<Cliente> findAll(){
		return clienteService.findAll();
	}

	@GetMapping(path = "/{id}")
	public Cliente findById(@PathVariable("id") Long id){
		return clienteService.getById(id);
	}
	
	@DeleteMapping(path = "/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		clienteService.deleteById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void save(@Valid @RequestBody ClienteDTO clienteDto) {
		clienteService.save(Mappers.getClient(clienteDto));
	}
	
	@PutMapping(path = "/{id}")
	public Cliente update(@Valid @RequestBody ClienteDTO clienteDto, @PathVariable("id") Long id) {
		return clienteService.updateById(id,Mappers.getClient(clienteDto) );
	}
	
	@GetMapping(path = "/{id}/pacotesFinalizados")
	public List<PacotesViagens> findPacotesFinalizados(@PathVariable("id") Long id){
		return clienteService.findAllPacotesFinalizados(id);
	}
	
}
