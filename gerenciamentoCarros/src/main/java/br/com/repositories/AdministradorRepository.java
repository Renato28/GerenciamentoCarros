package br.com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.model.Administrador;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Integer> {

	
}
