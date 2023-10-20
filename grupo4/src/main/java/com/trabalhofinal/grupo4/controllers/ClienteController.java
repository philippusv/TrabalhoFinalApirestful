package com.trabalhofinal.grupo4.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trabalhofinal.grupo4.entities.Cliente;
import com.trabalhofinal.grupo4.services.ClienteServices;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	ClienteServices clienteServices;

	@GetMapping
	public ResponseEntity<List<Cliente>> listarClientes() {
		return new ResponseEntity<>(clienteServices.listarClientes(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> buscarPorId(@PathVariable Integer id) {
		Cliente cliente = clienteServices.buscarClientePorId(id);
		if (cliente == null)
			return new ResponseEntity<>(cliente, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(cliente, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Cliente> salvar(@RequestBody Cliente cliente) {
		return new ResponseEntity<>(clienteServices.salvarCliente(cliente), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Cliente> atualizar(@RequestBody Cliente cliente) {
		return new ResponseEntity<>(clienteServices.atualizarCliente(cliente), HttpStatus.OK);
	}

	@DeleteMapping
	public ResponseEntity<String> deletarCliente(@RequestBody Cliente cliente) {
		if (Boolean.TRUE.equals(clienteServices.deletarCliente(cliente))) {
			return new ResponseEntity<>("Deletado com sucesso", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Não foi possivel deletar", HttpStatus.BAD_REQUEST);
		}
	}
}

