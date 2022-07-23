package com.fernando.myapi.os.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CPF;

import com.fernando.myapi.os.domain.Cliente;

import lombok.Data;


@Data
public class ClienteDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotEmpty(message = "O campo NOME é requerido")
	private String nome;
	
	@CPF
	@NotEmpty(message = "O campo CPF é requerido")
	private String cpf;
	
	@NotEmpty(message = "O campo TELEFONE é requerido")
	private String telefone;
	
	public ClienteDTO() {super();}
	
	public ClienteDTO(Cliente obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cpf = obj.getCpf();
		this.telefone = obj.getTelefone();
	}
}
