package com.trabalhofinal.grupo4.dto;

import java.math.BigDecimal;
import java.util.Date;

public class PedidoDTO {

	private Date dataEntrega;
	private Date dataEnvio;
	private Integer idPedido;
	private BigDecimal valorTotal;
	
	public PedidoDTO() {
		
	}

	public PedidoDTO(Date dataEntrega, Date dataEnvio, Integer idPedido, BigDecimal valorTotal) {
		
		this.dataEntrega = dataEntrega;
		this.dataEnvio = dataEnvio;
		this.idPedido = idPedido;
		this.valorTotal = valorTotal;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public Date getDataEnvio() {
		return dataEnvio;
	}

	public void setDataEnvio(Date dataEnvio) {
		this.dataEnvio = dataEnvio;
	}

	public Integer getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	
	
}
