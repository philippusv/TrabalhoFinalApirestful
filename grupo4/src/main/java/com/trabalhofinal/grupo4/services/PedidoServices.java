package com.trabalhofinal.grupo4.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalhofinal.grupo4.entities.Pedido;
import com.trabalhofinal.grupo4.repository.PedidoRepository;

@Service
public class PedidoServices {
	
	
	@Autowired  
	PedidoRepository pedidoRepo;
	
	public List<Pedido> listarPedidoServices(){
		return pedidoRepo.findAll();
	}
	
	public Pedido buscarPedidoServicesPorId(Integer id){

		
		return pedidoRepo.findById(id).orElse(null);
	}
	
	public Pedido salvarPedidoServices(Pedido pedidoServices) {
		return pedidoRepo.save(pedidoServices);
	}
	
	public Pedido atualizarPedidoServices(Pedido pedidoServices) {
		return pedidoRepo.save(pedidoServices);
	}
	
	public void deletarPedidoServices(Pedido pedidoServices) {
		pedidoRepo.delete(pedidoServices);
	}
}

