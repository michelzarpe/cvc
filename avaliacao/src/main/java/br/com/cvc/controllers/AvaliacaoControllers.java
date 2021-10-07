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

import br.com.cvc.entities.Avaliacao;
import br.com.cvc.entities.dto.AvaliacaoDTO;
import br.com.cvc.mapper.Mappers;
import br.com.cvc.services.IAvaliacaoService;

@RestController
@RequestMapping(value = "avaliacao")
public class AvaliacaoControllers {

	@Autowired
	private IAvaliacaoService avaliacaoService;
	
	@GetMapping(path = "/findAll")
	public List<Avaliacao> findAll(){
		return avaliacaoService.findAll();
	}

	@GetMapping(path = "/{id}")
	public Avaliacao findById(@PathVariable("id") Long id){
		return avaliacaoService.getById(id);
	}
	
	@DeleteMapping(path = "/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		avaliacaoService.deleteById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void save(@Valid @RequestBody AvaliacaoDTO AvaliacaoDto) {
		avaliacaoService.save(Mappers.getAvaliacao(AvaliacaoDto));
	}
	
	@PutMapping(path = "/{id}")
	public Avaliacao update(@Valid @RequestBody AvaliacaoDTO AvaliacaoDto, @PathVariable("id") Long id) {
		return avaliacaoService.updateById(id,Mappers.getAvaliacao(AvaliacaoDto) );
	}
	

	
}
