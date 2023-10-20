package com.trabalhofinal.grupo4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trabalhofinal.grupo4.entities.Cliente;

public interface  ClienteRepository extends JpaRepository<Cliente,Integer> { 
	
}


