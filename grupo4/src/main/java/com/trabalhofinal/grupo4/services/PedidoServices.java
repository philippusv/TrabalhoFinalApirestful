package com.trabalhofinal.grupo4.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalhofinal.grupo4.dto.ItemPedidoDTO;
import com.trabalhofinal.grupo4.dto.PedidoDTO;
import com.trabalhofinal.grupo4.entities.ItemPedido;
import com.trabalhofinal.grupo4.entities.Pedido;
import com.trabalhofinal.grupo4.repository.PedidoRepository;

@Service
public class PedidoServices {

	@Autowired
	PedidoRepository pedidoRepo;

	@Autowired
	EmailServices emailServices;

	public List<Pedido> listarPedidoServices() {
		return pedidoRepo.findAll();
	}

	public Pedido buscarPedidoServicesPorId(Integer id) {

		return pedidoRepo.findById(id).orElse(null);
	}

	public Pedido salvarPedidoServices(Pedido pedidoServices) {
		Pedido pedido = pedidoRepo.save(pedidoServices);
		emailServices.enviarEmail("caique@gmail.com", "relatório", pedido.toString());
		return pedido;

	}

	public Pedido atualizarPedidoServices(Pedido pedidoServices) {
		return pedidoRepo.save(pedidoServices);
	}

	public Boolean deletarPedido(Pedido pedido) {
		if (pedido == null)
			return false;

		Pedido pedidoExistente = buscarPedidoServicesPorId(pedido.getIdPedido());

		if (pedidoExistente == null)
			return false;

		pedidoRepo.delete(pedido);

		Pedido pedidoContinuaExistindo = buscarPedidoServicesPorId(pedido.getIdPedido());

		if (pedidoContinuaExistindo == null)
			return true;

		return false;
	}

	public List<PedidoDTO> listarPedidosComItens() {
		List<Pedido> pedidos = pedidoRepo.findAll();
		List<PedidoDTO> pedidosDTO = new ArrayList<>();

		for (Pedido pedido : pedidos) {
			PedidoDTO pedidoDTO = new PedidoDTO();
			pedidoDTO.setIdPedido(pedido.getIdPedido());
			pedidoDTO.setDataPedido(pedido.getDataPedido());
			pedidoDTO.setValorTotal(pedido.getValorTotal());

			List<ItemPedidoDTO> itensDTO = new ArrayList<>();
			for (ItemPedido itemPedido : pedido.getItensPedidos()) {
				ItemPedidoDTO itemPedidoDTO = new ItemPedidoDTO();
				itemPedidoDTO.setIdItemPedido(itemPedido.getProduto().getIdProduto());
				itemPedidoDTO.setNome(itemPedido.getProduto().getNome());
				itemPedidoDTO.setPrecoVenda(itemPedido.getProduto().getValorUnitario());
				itemPedidoDTO.setQuantidade(itemPedido.getQuantidade());
				itemPedidoDTO.setValorBruto(itemPedido.getValorBruto());
				itemPedidoDTO.setPercentualDesconto(itemPedido.getPercentualDesconto());
				itemPedidoDTO.setValorLiquido(itemPedido.getValorLiquido());
				itensDTO.add(itemPedidoDTO);
			}

			pedidoDTO.setItensPedido(itensDTO);
			pedidosDTO.add(pedidoDTO);
		}

		return pedidosDTO;
	}

	public PedidoDTO PedidoRelatorioPorId(Integer pedidoId) {
		Pedido pedido = pedidoRepo.findById(pedidoId).orElse(null);

		if (pedido == null) {
			throw new IllegalArgumentException("ID de pedido não encontrado: " + pedidoId);
		}

		PedidoDTO pedidoDTO = new PedidoDTO();
		pedidoDTO.setIdPedido(pedido.getIdPedido());
		pedidoDTO.setDataPedido(pedido.getDataPedido());
		pedidoDTO.setValorTotal(pedido.getValorTotal());

		List<ItemPedidoDTO> itensDTO = new ArrayList<>();
		for (ItemPedido itemPedido : pedido.getItensPedidos()) {
			ItemPedidoDTO itemPedidoDTO = new ItemPedidoDTO();
			itemPedidoDTO.setIdItemPedido(itemPedido.getProduto().getIdProduto());
			itemPedidoDTO.setNome(itemPedido.getProduto().getNome());
			itemPedidoDTO.setPrecoVenda(itemPedido.getProduto().getValorUnitario());
			itemPedidoDTO.setQuantidade(itemPedido.getQuantidade());
			itemPedidoDTO.setValorBruto(itemPedido.getValorBruto());
			itemPedidoDTO.setPercentualDesconto(itemPedido.getPercentualDesconto());
			itemPedidoDTO.setValorLiquido(itemPedido.getValorLiquido());
			itensDTO.add(itemPedidoDTO);
		}

		pedidoDTO.setItensPedido(itensDTO);

		return pedidoDTO;
	}
	public void gerarValorTotal(Pedido pedido) {
		BigDecimal valorTotal = new BigDecimal(0);
		if(pedido.getItensPedidos() != null) {
			for(ItemPedido itemPedido : pedido.getItensPedidos()) {
				valorTotal = valorTotal.add(itemPedido.getValorLiquido());
			}
		}
		pedido.setValorTotal(valorTotal);
		pedidoRepo.save(pedido);
	}
		
}
