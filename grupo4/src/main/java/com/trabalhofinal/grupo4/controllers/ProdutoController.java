package com.trabalhofinal.grupo4.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.trabalhofinal.grupo4.entities.Produto;
import com.trabalhofinal.grupo4.services.ProdutoServices;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	ProdutoServices produtoServices;

	@GetMapping
	public ResponseEntity<List<Produto>> listarProdutos() {
		return new ResponseEntity<>(produtoServices.listarProdutoServices(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Produto> buscarPorId(@PathVariable Integer id) {
		Produto produto = produtoServices.buscarProdutoServicesPorId(id);
	
			return new ResponseEntity<>(produto, HttpStatus.OK);
	}

//		@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE })
//		public ResponseEntity<Produto> salvar(@RequestBody Produto produto) {
//			return new ResponseEntity<>(produtoServices.salvarProdutoServices(produto), HttpStatus.CREATED);
//		}

	@PutMapping
	public ResponseEntity<Produto> atualizar(@RequestBody Produto produto) {
		return new ResponseEntity<>(produtoServices.atualizarProdutoServices(produto), HttpStatus.OK);
	}

	@DeleteMapping
	public ResponseEntity<String> deletarProduto(@RequestBody Produto produto) {
		if (Boolean.TRUE.equals(produtoServices.deletarProduto(produto))) {
			return new ResponseEntity<>("Deletado com sucesso", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Não foi possivel deletar", HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE })
	public ResponseEntity<Produto> cadastrar(@RequestPart("produto") Produto produto,
			@RequestPart("foto") MultipartFile foto) {

		Produto produtoDTO = produtoServices.salvarProdutoServices(produto);
		produtoServices.salvarFoto(foto);
		return new ResponseEntity<>(produtoDTO, HttpStatus.CREATED); // 201

	}
	
	@PostMapping("/comfoto")
	public ResponseEntity<Produto> salvarComFoto(@RequestPart("produto") String Produto,
			@RequestPart("foto") MultipartFile foto
			) throws IOException{
		return new ResponseEntity<>(produtoServices.salvarProdutoComFoto(Produto, foto), HttpStatus.CREATED);
	}
}
