package com.trabalhofinal.grupo4.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalhofinal.grupo4.entities.ItemPedido;
import com.trabalhofinal.grupo4.entities.Produto;
import com.trabalhofinal.grupo4.exceptions.ResourceBadRequestException;
import com.trabalhofinal.grupo4.exceptions.ResourceNotFoundException;
import com.trabalhofinal.grupo4.repository.ItemPedidoRepository;
import com.trabalhofinal.grupo4.repository.PedidoRepository;
import com.trabalhofinal.grupo4.repository.ProdutoRepository;

@Service
public class ItemPedidoServices {

	@Autowired
	ItemPedidoRepository itemPedidoRepo;

	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	PedidoServices pedidoServices;
	
	@Autowired
	PedidoRepository pedidoRepo;

	public Optional<ItemPedido> obterPorId(Integer id) {
		Optional<ItemPedido> optItemPedido = itemPedidoRepo.findById(id);

		if (optItemPedido.isEmpty()) {
			throw new ResourceNotFoundException("Não foi possível encontrar a itemPedido com id " + id);
		}

		return optItemPedido;
	}

	public List<ItemPedido> listarItemPedidoServices() {
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
		if (itemPedido == null)
			return false;

		ItemPedido itemPedidoExistente = buscarItemPedidoServicesPorId(itemPedido.getIdItemPedido());

		if (itemPedidoExistente == null)
			return false;

		itemPedidoRepo.delete(itemPedido);

		ItemPedido itemPedidoContinuaExistindo = buscarItemPedidoServicesPorId(itemPedido.getIdItemPedido());

		if (itemPedidoContinuaExistindo == null)
			return true;

		return false;

	}

	private void validarModelo(ItemPedido itemPedido) {
		if (itemPedido.getQuantidade() == null) {
			throw new ResourceBadRequestException("A quantidade do produto deve ser informada");
		}
	}

	public ItemPedido cadastrar(ItemPedido itemPedido) {
		validarModelo(itemPedido);
		Produto produto = produtoRepository.findById(itemPedido.getProduto().getIdProduto()).orElse(null);
		itemPedido.setPrecoVenda(produto.getValorUnitario());
		ItemPedido item = new ItemPedido(itemPedido.getIdItemPedido(), itemPedido.getQuantidade(),
				itemPedido.getPrecoVenda(), itemPedido.getPercentualDesconto(), itemPedido.getProduto(),
				itemPedido.getPedido());
		
		itemPedidoRepo.save(item);
		pedidoServices.gerarValorTotal(pedidoRepo.findById(itemPedido.getPedido().getIdPedido()).orElse(null));
		return item;
	}

//	public ItemPedido atualizar(Integer id, ItemPedido itemPedido) {
//
//		obterPorId(id);
//
//		validarModelo(itemPedido);
//		itemPedido.setValorBruto(BigDecimal.valueOf(calcularValorBruto(itemPedido)));
//		itemPedido.setValorLiquido(BigDecimal.valueOf(calcularValorLiquido(itemPedido)));
//		itemPedido.setIdItemPedido(id);
//		return itemPedidoRepo.save(itemPedido);
//	}

//	public double calcularValorBruto(ItemPedido itemPedido) {
//	    try {
//	        Optional<Produto> produtoOptional = produtoRepository.findById(itemPedido.getProduto().getIdProduto());
//
//	        if (produtoOptional.isPresent()) {
//	            Produto produto = produtoOptional.get();
//	            BigDecimal valorUnitario = produto.getValorUnitario();
//	            int quantidade = itemPedido.getQuantidade();
//
//	            return valorUnitario.multiply(BigDecimal.valueOf(quantidade)).doubleValue();
//	        } else {
//	            throw new ResourceNotFoundException("Produto não encontrado no repositório.");
//	        }
//	    } catch (Exception e) {
//	        throw new ResourceBadRequestException("Erro ao calcular o valor bruto: " + e.getMessage());
//	    }
//	}
//
//	
//	public double calcularValorLiquido(ItemPedido itemPedido) {
//	    BigDecimal percentual = itemPedido.getPercentualDesconto();
//	    if (percentual != null) {
//	        BigDecimal valorBruto = itemPedido.getValorBruto();
//	        BigDecimal desconto = percentual.divide(BigDecimal.valueOf(100));
//	        BigDecimal valorLiquido = valorBruto.subtract(valorBruto.multiply(desconto));
//	        return valorLiquido.doubleValue();  // Convertendo para double
//	    }
//	    return itemPedido.getValorBruto().doubleValue();  // Convertendo para double
//	}

}