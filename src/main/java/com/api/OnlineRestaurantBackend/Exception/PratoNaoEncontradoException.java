package com.api.OnlineRestaurantBackend.Exception;

public class PratoNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PratoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

	public PratoNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
