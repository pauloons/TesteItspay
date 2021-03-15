package com.teste.itspay;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.teste.itspay.domain.Cliente;
import com.teste.itspay.repositories.ClienteRepository;

@SpringBootApplication 
public class ItsPayApplication implements CommandLineRunner {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ItsPayApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		Cliente cli1 = new Cliente(null,"Paulo Alexandre", "pauloons@gmail.com", "02380509123");
		clienteRepository.saveAll(Arrays.asList(cli1));
	}
}
