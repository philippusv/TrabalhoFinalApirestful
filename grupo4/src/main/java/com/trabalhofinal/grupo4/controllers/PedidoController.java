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

import com.trabalhofinal.grupo4.dto.PedidoDTO;
import com.trabalhofinal.grupo4.entities.Pedido;
import com.trabalhofinal.grupo4.services.PedidoServices;

	@RestController
	@RequestMapping("/pedidos")
	public class PedidoController {
		
		@Autowired
		PedidoServices pedidoServices;

		@GetMapping
		public ResponseEntity<List<Pedido>> listarPedidos() {
			return new ResponseEntity<>(pedidoServices.listarPedidoServices(), HttpStatus.OK);
		}

		@GetMapping("/{id}")
		public ResponseEntity<Pedido> buscarPorId(@PathVariable Integer id) {
			Pedido pedido = pedidoServices.buscarPedidoServicesPorId(id);
			if (pedido == null)
				return new ResponseEntity<>(pedido, HttpStatus.NOT_FOUND);
			else
				return new ResponseEntity<>(pedido, HttpStatus.OK);
		}

		@PostMapping
		public ResponseEntity<Pedido> salvar(@RequestBody Pedido pedido) {
			return new ResponseEntity<>(pedidoServices.salvarPedidoServices(pedido), HttpStatus.CREATED);
		}

		@PutMapping
		public ResponseEntity<Pedido> atualizar(@RequestBody Pedido pedido) {
			return new ResponseEntity<>(pedidoServices.atualizarPedidoServices(pedido), HttpStatus.OK);
		}

		@DeleteMapping
		public ResponseEntity<String> deletarPedido(@RequestBody Pedido pedido) {
			if (Boolean.TRUE.equals(pedidoServices.deletarPedido(pedido))) {
				return new ResponseEntity<>("Deletado com sucesso", HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Não foi possivel deletar", HttpStatus.BAD_REQUEST);
			}
		}
		@GetMapping("/relatorio/{id}")
        public ResponseEntity<PedidoDTO> RelatorioPedido(@PathVariable Integer id) {
            PedidoDTO pedidoDTO = pedidoServices.listarPedidoServices(id);
            if (pedidoDTO == null) {
                return new ResponseEntity<>(pedidoDTO, HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(pedidoDTO, HttpStatus.OK);
            }
        }

    }
