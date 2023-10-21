package com.trabalhofinal.grupo4.dto;

import java.math.BigDecimal;

public class ItemPedidoDTO {

	private Integer idItemPedido;
	private String produto;
	private Integer quantidade;
	private BigDecimal valorLiquido;
	public ItemPedidoDTO() {
		
	}
	public ItemPedidoDTO(Integer idItemPedido, String produto, Integer quantidade, BigDecimal valorLiquido) {
		
		this.idItemPedido = idItemPedido;
		this.produto = produto;
		this.quantidade = quantidade;
		this.valorLiquido = valorLiquido;
	}
	public Integer getIdItemPedido() {
		return idItemPedido;
	}
	public void setIdItemPedido(Integer idItemPedido) {
		this.idItemPedido = idItemPedido;
	}
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public BigDecimal getValorLiquido() {
		return valorLiquido;
	}
	public void setValorLiquido(BigDecimal valorLiquido) {
		this.valorLiquido = valorLiquido;
	}
	
	
	
}
