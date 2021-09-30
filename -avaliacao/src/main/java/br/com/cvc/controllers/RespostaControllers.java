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

import br.com.cvc.entities.Resposta;
import br.com.cvc.entities.dto.RespostaDTO;
import br.com.cvc.mapper.Mappers;
import br.com.cvc.services.IRespostaService;

@RestController
@RequestMapping(value = "resposta")
public class RespostaControllers {

	@Autowired
	private Mappers mappers;
	
	@Autowired
	private IRespostaService RespostaService;
	
	@GetMapping(path = "/findAll")
	public List<Resposta> findAll(){
		return RespostaService.findAll();
	}

	@GetMapping(path = "/{id}")
	public Resposta findById(@PathVariable("id") Long id){
		return RespostaService.getById(id);
	}
	
	@DeleteMapping(path = "/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		RespostaService.deleteById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void save(@Valid @RequestBody RespostaDTO RespostaDto) {
		RespostaService.save(mappers.getResposta(RespostaDto));
	}
	
	@PutMapping(path = "/{id}")
	public Resposta update(@Valid @RequestBody RespostaDTO RespostaDto, @PathVariable("id") Long id) {
		return RespostaService.updateById(id,mappers.getResposta(RespostaDto) );
	}
	

	
}
