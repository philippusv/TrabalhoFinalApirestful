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

import com.trabalhofinal.grupo4.dto.CepDTO;
import com.trabalhofinal.grupo4.entities.Endereco;
import com.trabalhofinal.grupo4.services.EnderecoServices;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {
	
	@Autowired
	EnderecoServices enderecoServices;

	@GetMapping
	public ResponseEntity<List<Endereco>> listarEnderecos() {
		return new ResponseEntity<>(enderecoServices.listarEnderecos(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Endereco> buscarPorId(@PathVariable Integer id) {
		Endereco endereco = enderecoServices.buscarEnderecoPorId(id);
		if (endereco == null)
			return new ResponseEntity<>(endereco, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(endereco, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Endereco> salvar(@RequestBody Endereco endereco) {
		return new ResponseEntity<>(enderecoServices.salvarEndereco(endereco), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Endereco> atualizar(@RequestBody Endereco endereco) {
		return new ResponseEntity<>(enderecoServices.atualizarEndereco(endereco), HttpStatus.OK);
	}

	@DeleteMapping
	public ResponseEntity<String> deletarEndereco(@RequestBody Endereco endereco) {
		if (Boolean.TRUE.equals(enderecoServices.deletarEndereco(endereco))) {
			return new ResponseEntity<>("Deletado com sucesso", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Não foi possivel deletar", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/consulta-cep/{cep}")
    public ResponseEntity<CepDTO> consultaCep(@PathVariable String cep) {
        return new ResponseEntity<>(enderecoServices.consultaCep(cep), HttpStatus.OK);
    }
}
