package com.teste.itspay.service;

import java.util.List;
import java.util.Optional;

import com.teste.itspay.domain.enums.Tipo_Cliente;
import com.teste.itspay.dto.ClienteNewDTO;
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
	private void updateData(Cliente newObj, Cliente obj) {
		newObj.setvalorAPagar(newObj.getvalorAPagar());
	}
	public Cliente update(Cliente obj) {
		Cliente newObj = find(obj.getId());
		newObj.setvalorAPagar(newObj.getvalorAPagar());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
/*	public Cliente fromDTO(ClienteDTO objDto) {
		return new Cliente(objDto.getId(), objDto.getNome(), objDto.getEmail(),objDto.getCpfOuCnpj(), Tipo_Cliente.toEnum(objDto.getTipo()));
	}*/
	public Cliente fromDTO(ClienteNewDTO objDto) {
		Cliente cli = new Cliente(null, objDto.getNome(), objDto.getEmail(), objDto.getCpfOuCnpj(),
				Tipo_Cliente.toEnum(objDto.getTipo()),objDto.getValorAPagar());
		return cli;
	}
}