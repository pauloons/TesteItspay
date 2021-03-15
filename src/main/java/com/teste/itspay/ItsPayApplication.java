package com.teste.itspay;

import java.util.Arrays;

import com.teste.itspay.domain.enums.Tipo_Cliente;
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

		Cliente cli1 = new Cliente(null, "Paulo", "pauloons@gmail.com", "0238050923", Tipo_Cliente.PESSOAFISICA);
		Cliente cli2 = new Cliente(null, "Thamyres", "thamyres@gmail.com", "017657745", Tipo_Cliente.PESSOAFISICA);
		Cliente cli3 = new Cliente(null, "Gabriel", "gabi@gmail.com", "0238050923", Tipo_Cliente.PESSOAJURIDICA);
		clienteRepository.saveAll(Arrays.asList(cli1,cli2,cli3));
	}
}
