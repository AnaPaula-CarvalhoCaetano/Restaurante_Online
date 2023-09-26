package com.api.OnlineRestaurantBackend.Exception;

public class ItemPedidoNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ItemPedidoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

	public ItemPedidoNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
