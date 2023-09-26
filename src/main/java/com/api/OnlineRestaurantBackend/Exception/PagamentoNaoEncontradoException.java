package com.api.OnlineRestaurantBackend.Exception;

public class PagamentoNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PagamentoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

	public PagamentoNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
