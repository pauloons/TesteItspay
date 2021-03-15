package com.teste.itspay.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.teste.itspay.domain.enums.Tipo_Cliente;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
public class Cliente  implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	//@Column(unique = true)	
	private String email;
	private String cpfOuCnpj;
	private Integer tipo;
	private Integer valorAPagar;
	public Cliente() {

	}
	public Cliente(Integer id, String nome, String email, String cpfOuCnpj, Tipo_Cliente tipo, Integer valorAPagar) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpfOuCnpj = cpfOuCnpj;
		this.tipo = (tipo==null) ? null : tipo.getCod();
		this.valorAPagar = valorAPagar;
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

	public Tipo_Cliente getTipo() {
		return Tipo_Cliente.toEnum(tipo);
	}

	public void setTipo(Tipo_Cliente tipo) {
		this.tipo = tipo.getCod();
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public Integer getvalorAPagar() {
		return valorAPagar;
	}
	public void setvalorAPagar(Integer valorAPagar) {
		this.valorAPagar = valorAPagar;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}


