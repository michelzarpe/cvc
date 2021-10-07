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

import br.com.cvc.entities.Viagem;
import br.com.cvc.entities.dto.ViagemDTO;
import br.com.cvc.mapper.Mappers;
import br.com.cvc.services.IViagemService;

@RestController
@RequestMapping(value = "viagens")
public class ViagemControllers {

	@Autowired
	private IViagemService viagemService;
	
	@GetMapping(path = "/findAll")
	public List<Viagem> findAll(){
		return viagemService.findAll();
	}

	@GetMapping(path = "/{id}")
	public Viagem findById(@PathVariable("id") Long id){
		return viagemService.getById(id);
	}
	
	@DeleteMapping(path = "/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		viagemService.deleteById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void save(@Valid @RequestBody ViagemDTO objDTO) {
		viagemService.save(Mappers.getViagem(objDTO));
	}
	
	@PutMapping(path = "/{id}")
	public Viagem update(@Valid @RequestBody ViagemDTO objDto, @PathVariable("id") Long id) {
		return viagemService.updateById(id,Mappers.getViagem(objDto) );
	}
	
}
