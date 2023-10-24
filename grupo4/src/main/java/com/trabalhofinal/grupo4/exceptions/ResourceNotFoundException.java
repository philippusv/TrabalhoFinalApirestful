package com.trabalhofinal.grupo4.exceptions;

	public class ResourceNotFoundException extends RuntimeException {
		public ResourceNotFoundException(String mensagem) {
			super(mensagem);
		}	
}
