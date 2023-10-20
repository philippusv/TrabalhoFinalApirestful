package com.trabalhofinal.grupo4.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalhofinal.grupo4.entities.Endereco;
import com.trabalhofinal.grupo4.repository.EnderecoRepository;

@Service
public class EnderecoServices {

	
	
	
		@Autowired  
		EnderecoRepository enderecoRepo;
		
		public List<Endereco> listarEnderecos(){
			return enderecoRepo.findAll();
		}
		
		public Endereco buscarEnderecoPorId(Integer id) {

			
			return enderecoRepo.findById(id).orElse(null);
		}
		
		public Endereco salvarEndereco(Endereco endereco) {
			return enderecoRepo.save(endereco);
		}
		
		public Endereco atualizarEndereco(Endereco endereco) {
			return enderecoRepo.save(endereco);
		}
		
		public Boolean deletarEndereco(Endereco endereco) {
	        if(endereco == null)
	            return false;

	        Endereco enderecoExistente = buscarEnderecoPorId(endereco.getIdEndereco());

	        if(enderecoExistente == null)
	            return false;

	        enderecoRepo.delete(endereco);

	        Endereco enderecoContinuaExistindo = buscarEnderecoPorId(endereco.getIdEndereco());

	        if(enderecoContinuaExistindo == null)
	            return true;

	        return false;

	    }
	}
