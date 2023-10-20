package com.trabalhofinal.grupo4.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalhofinal.grupo4.entities.ItemPedido;
import com.trabalhofinal.grupo4.repository.ClienteRepository;


@Service
public class ItemPedidoServices {
	
//CRUD
//recuperar todos os itemPedidoServicess
//recuperar um itemPedidoServices pela sua chave primária
//salvar um novo itemPedidoServices
//atualizar um determinado itemPedidoServices
//deletar um determinado itemPedidoServices
	
	@Autowired  // essa anotação é para injeção de dependencia, recursos de outro lugar
	ItemPedidoServicesRepository itemPedidoServicesRepo;
	
	public List<ItemPedidoServices> listarItemPedidoServicess(){
		return itemPedidoServicesRepo.findAll();
	}
	
	public ItemPedidoServices buscarItemPedidoServicesPorId(Integer id) {
//		return itemPedidoServicesRepo.findById(id).get();
//		Optional<ItemPedidoServices> itemPedidoServicesBanco = itemPedidoServicesRepo.findById(id);
//		if(itemPedidoServicesBanco.isPresent())
//			return itemPedidoServicesBanco.get();
//		else
//			return null;
		
		return itemPedidoServicesRepo.findById(id).orElse(null);
	}
	
	public ItemPedidoServices salvarItemPedidoServices(ItemPedidoServices itemPedidoServices) {
		return itemPedidoServicesRepo.save(itemPedidoServices);
	}
	
	public ItemPedidoServices atualizarItemPedidoServices(ItemPedidoServices itemPedidoServices) {
		return itemPedidoServicesRepo.save(itemPedidoServices);
	}
	
	public void deletarItemPedidoServices(ItemPedidoServices itemPedidoServices) {
		itemPedidoServicesRepo.delete(itemPedidoServices);
		//ItemPedidoServices confereItemPedidoServicesDeletado = buscarItemPedidoServicesPorId(itemPedidoServices.getNumeroMatricaItemPedidoServices());
	}
}