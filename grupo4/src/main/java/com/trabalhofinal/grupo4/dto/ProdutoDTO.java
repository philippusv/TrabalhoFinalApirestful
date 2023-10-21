package com.trabalhofinal.grupo4.dto;

import java.math.BigDecimal;

public class ProdutoDTO {

	private String nome;
	private BigDecimal valorUnitario;
	private Integer qtdEstoque;
	private Integer idProduto;
	
	public ProdutoDTO() {
		
	}
	
	public ProdutoDTO(String nome, BigDecimal valorUnitario, Integer qtdEstoque, Integer idProduto) {
		
		this.nome = nome;
		this.valorUnitario = valorUnitario;
		this.qtdEstoque = qtdEstoque;
		this.idProduto = idProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Integer getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(Integer qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}
	
	
}
