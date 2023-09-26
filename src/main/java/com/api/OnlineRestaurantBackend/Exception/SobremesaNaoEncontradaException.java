package com.api.OnlineRestaurantBackend.Exception;

public class SobremesaNaoEncontradaException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SobremesaNaoEncontradaException(String mensagem) {
		super(mensagem);
	}

	public SobremesaNaoEncontradaException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
