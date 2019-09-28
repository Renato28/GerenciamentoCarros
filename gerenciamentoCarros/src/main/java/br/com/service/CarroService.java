package br.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.exceptions.ObjectNotFoundException;
import br.com.model.Carro;
import br.com.repositories.CarroRepository;

@Service
public class CarroService {

	@Autowired
	private CarroRepository carroRepository;
	
	public Carro find(Integer id) {
		Optional<Carro> carro = carroRepository.findById(id);
		return carro.orElseThrow(() -> new ObjectNotFoundException(
				"carro não encontrado! Id: " + id + ", Carro: " + Carro.class.getName()));
	}
	
	@Transactional
	public Carro insert(Carro carro) {
		carro.setId(null);
		carro = carroRepository.save(carro);
		return carro;
	}
	
	public Carro update(Carro carro) {
		Carro newCarro = find(carro.getId());
		return carroRepository.save(newCarro);
	}
	
	public List<Carro> findAll(){
		return carroRepository.findAll();
	}
	
	public void delete(Integer id) {
		find(id);
	}
}
