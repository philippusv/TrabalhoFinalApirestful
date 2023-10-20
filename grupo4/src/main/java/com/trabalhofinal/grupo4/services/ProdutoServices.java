package com.trabalhofinal.grupo4.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalhofinal.grupo4.entities.Produto;
import com.trabalhofinal.grupo4.repository.ProdutoRepository;

@Service
public class ProdutoServices {
	
//CRUD
//recuperar todos os produtoServicess
//recuperar um produtoServices pela sua chave primária
//salvar um novo produtoServices
//atualizar um determinado produtoServices
//deletar um determinado produtoServices
	
	@Autowired  // essa anotação é para injeção de dependencia, recursos de outro lugar
	ProdutoServicesRepository produtoServicesRepo;
	
	public List<ProdutoServices> listarProdutoServicess(){
		return produtoServicesRepo.findAll();
	}
	
	public ProdutoServices buscarProdutoServicesPorId(Integer id){
//		return produtoServicesRepo.findById(id).get();
//		Optional<ProdutoServices> produtoServicesBanco = produtoServicesRepo.findById(id);
//		if(produtoServicesBanco.isPresent())
//			return produtoServicesBanco.get();
//		else
//			return null;
		
		return produtoServicesRepo.findById(id).orElse(null);
	}
	
	public ProdutoServices salvarProdutoServices(ProdutoServices produtoServices) {
		return produtoServicesRepo.save(produtoServices);
	}
	
	public ProdutoServices atualizarProdutoServices(ProdutoServices produtoServices) {
		return produtoServicesRepo.save(produtoServices);
	}
	
	public void deletarProdutoServices(ProdutoServices produtoServices) {
		produtoServicesRepo.delete(produtoServices);
		//ProdutoServices confereProdutoServicesDeletado = buscarProdutoServicesPorId(produtoServices.getNumeroMatricaProdutoServices());
	}
}
