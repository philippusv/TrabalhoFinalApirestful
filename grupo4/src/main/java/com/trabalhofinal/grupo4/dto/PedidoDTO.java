package com.trabalhofinal.grupo4.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class PedidoDTO {

	private Integer idPedido;
	private Date dataPedido;
	private BigDecimal valorTotal;
	private List<ItemPedidoDTO> itensPedido;

	public PedidoDTO() {

	}

	public PedidoDTO(Integer idPedido, Date dataPedido, BigDecimal valorTotal, List<ItemPedidoDTO> itensPedido) {
		this.idPedido = idPedido;
		this.dataPedido = dataPedido;
		this.valorTotal = valorTotal;
		this.itensPedido = itensPedido;
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

	public List<ItemPedidoDTO> getItensPedido() {
		return itensPedido;
	}

	public void setItensPedido(List<ItemPedidoDTO> itensPedido) {
		this.itensPedido = itensPedido;
	}

}
