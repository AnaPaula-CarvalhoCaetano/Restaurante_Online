package com.api.OnlineRestaurantBackend.Exception;

public class BebidaNaoEncontradaException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BebidaNaoEncontradaException(String message) {
		super(message);
	}

	public BebidaNaoEncontradaException(String message, Throwable cause) {
		super(message, cause);
	}
}
