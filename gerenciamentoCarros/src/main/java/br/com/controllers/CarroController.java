package br.com.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.model.Carro;
import br.com.service.CarroService;

@RestController
@RequestMapping(value = "/carros")
public class CarroController {

	@Autowired
	private CarroService carroService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Carro> find (@PathVariable Integer id){
		Carro carro = carroService.find(id);
		return ResponseEntity.ok().body(carro);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Carro> insert(@Valid @PathVariable Carro carro){
		Carro newCarro = carroService.insert(carro);
		return ResponseEntity.ok().body(newCarro);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Carro> findAll(){
		return carroService.findAll();
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Carro> update(@Valid @RequestBody Carro carro, Integer id){
		Carro newCarro = carroService.find(id);
		newCarro = carroService.update(carro);
		newCarro.setId(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete (@PathVariable Integer id){
		carroService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
