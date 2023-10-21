package com.trabalhofinal.grupo4.dto;

public class EnderecoDTO {

	private Integer idEndereco;
	private String cep;
	public EnderecoDTO() {
		
	}
	public EnderecoDTO(Integer idEndereco, String cep) {
		
		this.idEndereco = idEndereco;
		this.cep = cep;
	}
	public Integer getIdEndereco() {
		return idEndereco;
	}
	public void setIdEndereco(Integer idEndereco) {
		this.idEndereco = idEndereco;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}

	
	
}
