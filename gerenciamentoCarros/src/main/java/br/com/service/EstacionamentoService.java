package br.com.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.model.Estacionamento;
import br.com.repositories.EstacionamentoRepository;

@Service
public class EstacionamentoService {
	
	@Autowired
	private EstacionamentoRepository estacionamentoRepository;

	@Transactional
	public Estacionamento insert(Estacionamento estacionamento) {

		estacionamento.setId(null);
		estacionamento = estacionamentoRepository.save(estacionamento);
		return estacionamento;
		
	}
}
