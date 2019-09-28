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

import br.com.model.Cliente;
import br.com.service.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Cliente> find(@PathVariable Integer id){
		Cliente cliente = clienteService.find(id);
		return ResponseEntity.ok().body(cliente);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Cliente> insert(@Valid @RequestBody Cliente cliente){
		Cliente newCliente = clienteService.insert(cliente);
		return ResponseEntity.ok().body(newCliente);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Cliente> findAll(){
		return clienteService.findAll();
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Cliente> update(@Valid @RequestBody Cliente cliente, @PathVariable Integer id){
		Cliente existente = clienteService.find(id);
		existente = clienteService.update(cliente);
		existente.setId(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		clienteService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
