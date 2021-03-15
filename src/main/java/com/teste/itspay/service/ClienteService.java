package com.teste.itspay.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.itspay.domain.Cliente;
import com.teste.itspay.dto.ClienteDTO;
import com.teste.itspay.repositories.ClienteRepository;
import com.teste.itspay.service.exeptions.ObjectNotFoundExeption;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;

	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundExeption(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}

	public List<Cliente> findAll() {
		return repo.findAll();
	}

	public Cliente insert(Cliente obj) {
		obj.setId(null);
   return repo.save(obj);
    }
	
	public Cliente fromDTO(ClienteDTO objDto) {
		return new Cliente(objDto.getId(), objDto.getNome(),objDto.getEmail(),objDto.getCpfOuCnpj());
	}
	
}