package com.api.OnlineRestaurantBackend.Exception;

public class ItemCarrinhoNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ItemCarrinhoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

	public ItemCarrinhoNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
