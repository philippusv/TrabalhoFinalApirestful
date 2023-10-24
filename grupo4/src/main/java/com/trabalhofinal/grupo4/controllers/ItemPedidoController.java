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

import com.trabalhofinal.grupo4.entities.ItemPedido;
import com.trabalhofinal.grupo4.services.ItemPedidoServices;

@RestController
@RequestMapping("/itempedidos")
public class ItemPedidoController {
	
	@Autowired
	ItemPedidoServices itemPedidoServices;

	@GetMapping
	public ResponseEntity<List<ItemPedido>> listarItemPedidos() {
		return new ResponseEntity<>(itemPedidoServices.listarItemPedidoServices(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ItemPedido> buscarPorId(@PathVariable Integer id) {
		ItemPedido itemPedido = itemPedidoServices.buscarItemPedidoServicesPorId(id);
		if (itemPedido == null)
			return new ResponseEntity<>(itemPedido, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(itemPedido, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<ItemPedido> salvar(@RequestBody ItemPedido itemPedido) {
		return new ResponseEntity<>(itemPedidoServices.cadastrar(itemPedido), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<ItemPedido> atualizar(@RequestBody ItemPedido itemPedido) {
		return new ResponseEntity<>(itemPedidoServices.atualizarItemPedidoServices(itemPedido), HttpStatus.OK);
	}

	@DeleteMapping
	public ResponseEntity<String> deletarItemPedido(@RequestBody ItemPedido itemPedido) {
		if (Boolean.TRUE.equals(itemPedidoServices.deletarItemPedido(itemPedido))) {
			return new ResponseEntity<>("Deletado com sucesso", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Não foi possivel deletar", HttpStatus.BAD_REQUEST);
		}
	}
}
