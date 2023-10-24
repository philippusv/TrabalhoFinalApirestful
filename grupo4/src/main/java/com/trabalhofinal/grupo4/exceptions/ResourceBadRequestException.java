package com.trabalhofinal.grupo4.exceptions;

public class ResourceBadRequestException extends RuntimeException {

	public ResourceBadRequestException(String mensagem) {
		super(mensagem);
	}
}