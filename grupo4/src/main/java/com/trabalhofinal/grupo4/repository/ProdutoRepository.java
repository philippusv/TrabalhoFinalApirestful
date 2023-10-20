package com.trabalhofinal.grupo4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trabalhofinal.grupo4.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto,Integer> { 
	
}

