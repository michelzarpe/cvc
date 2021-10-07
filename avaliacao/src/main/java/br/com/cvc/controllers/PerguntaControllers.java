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

import br.com.cvc.entities.Pergunta;
import br.com.cvc.entities.dto.PerguntaDTO;
import br.com.cvc.mapper.Mappers;
import br.com.cvc.services.IPerguntaService;

@RestController
@RequestMapping(value = "pergunta")
public class PerguntaControllers {

	@Autowired
	private IPerguntaService perguntaService;
	
	@GetMapping(path = "/findAll")
	public List<Pergunta> findAll(){
		return perguntaService.findAll();
	}

	@GetMapping(path = "/{id}")
	public Pergunta findById(@PathVariable("id") Long id){
		return perguntaService.getById(id);
	}
	
	@DeleteMapping(path = "/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		perguntaService.deleteById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void save(@Valid @RequestBody PerguntaDTO perguntaDto) {
		perguntaService.save(Mappers.getPergunta(perguntaDto));
	}
	
	@PutMapping(path = "/{id}")
	public Pergunta update(@Valid @RequestBody PerguntaDTO perguntaDto, @PathVariable("id") Long id) {
		return perguntaService.updateById(id,Mappers.getPergunta(perguntaDto) );
	}
	

	
}
