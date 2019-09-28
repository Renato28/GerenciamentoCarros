package br.com.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity(name = "administrador")
public class Administrador extends Pessoa{

	@Id
	private Integer id;
	@NotNull
	private String cpf;
	@Null
	@DateTimeFormat(pattern = "dd-mm-yyyy")
	@JsonFormat(pattern = "dd-mm-yyyy")
	private Date dataNascimento;
	
}
