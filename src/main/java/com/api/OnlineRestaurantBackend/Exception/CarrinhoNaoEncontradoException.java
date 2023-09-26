package com.api.OnlineRestaurantBackend.Exception;

public class CarrinhoNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CarrinhoNaoEncontradoException(String message) {
		super(message);
	}

	public CarrinhoNaoEncontradoException(String message, Throwable cause) {
		super(message, cause);
	}
}
