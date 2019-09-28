package br.com.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity(name = "cliente")
public class Cliente extends Pessoa{

	@Id
	private Integer id;
	@NotNull
	private String cpf;
	@NotNull
	private Date dataNascimento;
}
