package com.trabalhofinal.grupo4.dto;

import java.math.BigDecimal;
import java.util.Date;

public class RelatorioPedidoDTO {

	private Integer idPedido;
	private Date dataPedido; 
	private BigDecimal valorTotal;
	
	public RelatorioPedidoDTO() {
		
	}

	public RelatorioPedidoDTO(Integer idPedido, Date dataPedido, BigDecimal valorTotal) {
		
		this.idPedido = idPedido;
		this.dataPedido = dataPedido;
		this.valorTotal = valorTotal;
	}

	public Integer getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}

	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	
}
