package com.teste.itspay.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

import com.teste.itspay.domain.Cliente;
import com.teste.itspay.service.validation.ClienteInsert;

@ClienteInsert
public class ClienteDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	@NotBlank(message = "Nome Obrigatorio")
	private String nome;
	private String email;
	private String cpfOuCnpj;

	public ClienteDTO() {
	}

	public ClienteDTO(Cliente obj) {
		id = obj.getId();
		nome = obj.getNome();
		email = obj.getEmail();
		cpfOuCnpj = obj.getCpfOuCnpj();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}

	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}

}
