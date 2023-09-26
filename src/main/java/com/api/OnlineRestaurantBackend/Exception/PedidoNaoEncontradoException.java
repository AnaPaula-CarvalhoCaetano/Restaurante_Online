package com.api.OnlineRestaurantBackend.Exception;

public class PedidoNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PedidoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

	public PedidoNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
