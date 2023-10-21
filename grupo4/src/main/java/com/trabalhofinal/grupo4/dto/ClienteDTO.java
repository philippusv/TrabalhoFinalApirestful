package com.trabalhofinal.grupo4.dto;

public class ClienteDTO {

	private String cpf;
	private String email;
	private Integer idCliente;
	private String nomeCompleto;
	private String telefone;
	
	public ClienteDTO() {
		
	}

	public ClienteDTO(String cpf, String email, Integer idCliente, String nomeCompleto, String telefone) {
		
		this.cpf = cpf;
		this.email = email;
		this.idCliente = idCliente;
		this.nomeCompleto = nomeCompleto;
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
	
}
