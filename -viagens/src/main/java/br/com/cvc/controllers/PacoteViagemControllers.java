package br.com.cvc.controllers;

import java.time.ZonedDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.cvc.entities.PacoteViagem;
import br.com.cvc.entities.dto.PacoteViagemDTO;
import br.com.cvc.mapper.Mappers;
import br.com.cvc.services.IPacoteViagemService;

@RestController
@RequestMapping(value = "pacoteViagens")
public class PacoteViagemControllers {

	@Autowired
	private IPacoteViagemService pacoteViagemService;
	
	@Autowired
	private Mappers mappers;
	
	@GetMapping(path = "/findAll")
	public List<PacoteViagem> findAll(){
		return pacoteViagemService.findAll();
	}

	@GetMapping(path = "/{id}")
	public PacoteViagem findById(@PathVariable("id") Long id){
		return pacoteViagemService.getById(id);
	}
	
	@DeleteMapping(path = "/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		pacoteViagemService.deleteById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void save(@Valid @RequestBody PacoteViagemDTO objDTO) {
		pacoteViagemService.save(mappers.getPacoteViagem(objDTO));
	}
	
	@PutMapping(path = "/{id}")
	public PacoteViagem update(@Valid @RequestBody PacoteViagemDTO objDto, @PathVariable("id") Long id) {
		return pacoteViagemService.updateById(id, mappers.getPacoteViagem(objDto) );
	}
	
	@GetMapping(path = "/cliente/{idCliente}")
	public List<PacoteViagem> findAllPacoteViagemByDataFim(
			@PathVariable("idCliente") Long idCliente,
			@RequestParam("dataFim") @DateTimeFormat(iso = ISO.DATE_TIME) ZonedDateTime dataFim){
		return pacoteViagemService.findAllPacoteViagemByDataFimAndCliente(idCliente, dataFim);
	}
	
}
