package br.com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.model.Carro;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Integer> {

	
}
