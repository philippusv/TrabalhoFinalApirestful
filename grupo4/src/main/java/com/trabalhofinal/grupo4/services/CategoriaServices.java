package com.trabalhofinal.grupo4.services;

import java.util.List;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalhofinal.grupo4.entities.Categoria;
import com.trabalhofinal.grupo4.repository.CategoriaRepository;

@Service
public class CategoriaServices {
	

	
	@Autowired  
	CategoriaRepository categoriaRepo;
	
	public List<Categoria> listarCategorias(){
		return categoriaRepo.findAll();
	}
	
	public Categoria buscarCategoriaPorId(Integer id) {

		
		return categoriaRepo.findById(id).orElse(null);
	}
	
	public Categoria salvarCategoria(Categoria categoria) {
		return categoriaRepo.save(categoria);
	}
	
	public Categoria atualizarCategoria(Categoria categoria) {
		return categoriaRepo.save(categoria);
	}
	
	public void deletarCategoria(Categoria categoria) {
		categoriaRepo.delete(categoria);
	}
}