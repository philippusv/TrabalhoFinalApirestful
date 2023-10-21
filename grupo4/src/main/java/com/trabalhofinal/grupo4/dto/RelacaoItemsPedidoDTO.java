package com.trabalhofinal.grupo4.dto;

import java.math.BigDecimal;

public class RelacaoItemsPedidoDTO {

	private Integer codigo;
	private String nomeProduto;
	private BigDecimal precoVenda;
	private Integer quantidade;
	private BigDecimal valorBruto;
	private Double percentualDesconto;
	private BigDecimal valorLiquido;
	
	public RelacaoItemsPedidoDTO() {
		
	}

	public RelacaoItemsPedidoDTO(Integer codigo, String nomeProduto, BigDecimal precoVenda, Integer quantidade,
			BigDecimal valorBruto, Double percentualDesconto, BigDecimal valorLiquido) {
		
		this.codigo = codigo;
		this.nomeProduto = nomeProduto;
		this.precoVenda = precoVenda;
		this.quantidade = quantidade;
		this.valorBruto = valorBruto;
		this.percentualDesconto = percentualDesconto;
		this.valorLiquido = valorLiquido;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public BigDecimal getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(BigDecimal precoVenda) {
		this.precoVenda = precoVenda;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValorBruto() {
		return valorBruto;
	}

	public void setValorBruto(BigDecimal valorBruto) {
		this.valorBruto = valorBruto;
	}

	public Double getPercentualDesconto() {
		return percentualDesconto;
	}

	public void setPercentualDesconto(Double percentualDesconto) {
		this.percentualDesconto = percentualDesconto;
	}

	public BigDecimal getValorLiquido() {
		return valorLiquido;
	}

	public void setValorLiquido(BigDecimal valorLiquido) {
		this.valorLiquido = valorLiquido;
	}
	
	
}
