package com.trabalhofinal.grupo4.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalhofinal.grupo4.entities.Produto;
import com.trabalhofinal.grupo4.repository.ProdutoRepository;

@Service
public class ProdutoServices {
	
	
	@Autowired  
	ProdutoRepository produtoRepo;
	
	public List<Produto> listarProdutoServices(){
		return produtoRepo.findAll();
	}
	
	public Produto buscarProdutoServicesPorId(Integer id){

		
		return produtoRepo.findById(id).orElse(null);
	}
	
	public Produto salvarProdutoServices(Produto produtoServices) {
		return produtoRepo.save(produtoServices);
	}
	
	public Produto atualizarProdutoServices(Produto produtoServices) {
		return produtoRepo.save(produtoServices);
	}
	
	public void deletarProdutoServices(Produto produtoServices) {
		produtoRepo.delete(produtoServices);
	}
}
