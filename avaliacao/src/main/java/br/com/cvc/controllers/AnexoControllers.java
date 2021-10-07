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

import br.com.cvc.entities.Anexo;
import br.com.cvc.entities.dto.AnexoDTO;
import br.com.cvc.mapper.Mappers;
import br.com.cvc.services.IAnexoService;

@RestController
@RequestMapping(value = "anexos")
public class AnexoControllers {

	@Autowired
	private Mappers mappers;
	
	@Autowired
	private IAnexoService AnexoService;
	
	@GetMapping(path = "/findAll")
	public List<Anexo> findAll(){
		return AnexoService.findAll();
	}

	@GetMapping(path = "/{id}")
	public Anexo findById(@PathVariable("id") Long id){
		return AnexoService.getById(id);
	}
	
	@DeleteMapping(path = "/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		AnexoService.deleteById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void save(@Valid @RequestBody AnexoDTO AnexoDto) {
		AnexoService.save(mappers.getAnexo(AnexoDto));
	}
	
	@PutMapping(path = "/{id}")
	public Anexo update(@Valid @RequestBody AnexoDTO AnexoDto, @PathVariable("id") Long id) {
		return AnexoService.updateById(id,mappers.getAnexo(AnexoDto) );
	}
}
