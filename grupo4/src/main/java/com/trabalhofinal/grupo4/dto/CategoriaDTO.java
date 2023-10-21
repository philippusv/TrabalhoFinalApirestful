package com.trabalhofinal.grupo4.dto;

public class CategoriaDTO {

	private String descricao;
	private Integer idCategoria;
	private String nome;
	
	
	public CategoriaDTO() {
		
	}
	
	public CategoriaDTO(String descricao, Integer idCategoria, String nome) {
		
		this.descricao = descricao;
		this.idCategoria = idCategoria;
		this.nome = nome;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public Integer getIdCategoria() {
		return idCategoria;
	}


	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
