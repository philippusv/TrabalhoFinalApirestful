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
	
	public Boolean deletarCategoria(Categoria categoria) {
        if(categoria == null)
            return false;

        Categoria categoriaExistente = buscarCategoriaPorId(categoria.getIdCategoria());

        if(categoriaExistente == null)
            return false;

        categoriaRepo.delete(categoria);

        Categoria categoriaContinuaExistindo = buscarCategoriaPorId(categoria.getIdCategoria());

        if(categoriaContinuaExistindo == null)
            return true;

        return false;

    }
}