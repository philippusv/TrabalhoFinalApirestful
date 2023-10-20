package com.trabalhofinal.grupo4.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalhofinal.grupo4.entities.ItemPedido;
import com.trabalhofinal.grupo4.repository.ItemPedidoRepository;


@Service
public class ItemPedidoServices {
	

	
	@Autowired  
	ItemPedidoRepository itemPedidoRepo;
	
	public List<ItemPedido> listarItemPedidoServices(){
		return itemPedidoRepo.findAll();
	}
	
	public ItemPedido buscarItemPedidoServicesPorId(Integer id) {

		
		return itemPedidoRepo.findById(id).orElse(null);
	}
	
	public ItemPedido salvarItemPedidoServices(ItemPedido itemPedidoServices) {
		return itemPedidoRepo.save(itemPedidoServices);
	}
	
	public ItemPedido atualizarItemPedidoServices(ItemPedido itemPedidoServices) {
		return itemPedidoRepo.save(itemPedidoServices);
	}
	
	public Boolean deletarItemPedido(ItemPedido itemPedido) {
        if(itemPedido == null)
            return false;

        ItemPedido itemPedidoExistente = buscarItemPedidoServicesPorId(itemPedido.getIdItemPedido());

        if(itemPedidoExistente == null)
            return false;

        itemPedidoRepo.delete(itemPedido);

        ItemPedido itemPedidoContinuaExistindo = buscarItemPedidoServicesPorId(itemPedido.getIdItemPedido());

        if(itemPedidoContinuaExistindo == null)
            return true;

        return false;

    }
}