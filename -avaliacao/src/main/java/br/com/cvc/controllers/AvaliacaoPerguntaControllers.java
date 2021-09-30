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

import br.com.cvc.entities.AvaliacaoPergunta;
import br.com.cvc.entities.dto.AvaliacaoPerguntaDTO;
import br.com.cvc.mapper.Mappers;
import br.com.cvc.services.IAvaliacaoPerguntaService;



@RestController
@RequestMapping(value = "avaliacaoPergunta")
public class AvaliacaoPerguntaControllers {

	@Autowired
	private Mappers mappers; 
	
	@Autowired
	private IAvaliacaoPerguntaService avaliacaoPerguntaService;
	
	@GetMapping(path = "/findAll")
	public List<AvaliacaoPergunta> findAll(){
		return avaliacaoPerguntaService.findAll();
	}

	@GetMapping(path = "/{id}")
	public AvaliacaoPergunta findById(@PathVariable("id") Long id){
		return avaliacaoPerguntaService.getById(id);
	}
	
	@DeleteMapping(path = "/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		avaliacaoPerguntaService.deleteById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void save(@Valid @RequestBody AvaliacaoPerguntaDTO avaliacaoPerguntaDto) {
		avaliacaoPerguntaService.save(mappers.getAvaliacaoPergunta(avaliacaoPerguntaDto));
	}
	
	@PutMapping(path = "/{id}")
	public AvaliacaoPergunta update(@Valid @RequestBody AvaliacaoPerguntaDTO avaliacaoPerguntaDto, @PathVariable("id") Long id) {
		return avaliacaoPerguntaService.updateById(id,mappers.getAvaliacaoPergunta(avaliacaoPerguntaDto) );
	}
	

	
}
