package com.trabalhofinal.grupo4.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalhofinal.grupo4.entities.Cliente;
import com.trabalhofinal.grupo4.repository.ClienteRepository;

@Service
public class ClienteServices {
	
//CRUD
//recuperar todos os clientes
//recuperar um cliente pela sua chave primária
//salvar um novo cliente
//atualizar um determinado cliente
//deletar um determinado cliente
	
	@Autowired  // essa anotação é para injeção de dependencia, recursos de outro lugar
	ClienteRepository clienteRepo;
	
	public List<Cliente> listarClientes(){
		return clienteRepo.findAll();
	}
	
	public Cliente buscarClientePorId(Integer id) {
//		return clienteRepo.findById(id).get();
//		Optional<Cliente> clienteBanco = clienteRepo.findById(id);
//		if(clienteBanco.isPresent())
//			return clienteBanco.get();
//		else
//			return null;
		
		return clienteRepo.findById(id).orElse(null);
	}
	
	public Cliente salvarCliente(Cliente cliente) {
		return clienteRepo.save(cliente);
	}
	
	public Cliente atualizarCliente(Cliente cliente) {
		return clienteRepo.save(cliente);
	}
	
	public void deletarCliente(Cliente cliente) {
		clienteRepo.delete(cliente);
		//Cliente confereClienteDeletado = buscarClientePorId(cliente.getNumeroMatricaCliente());
	}
}