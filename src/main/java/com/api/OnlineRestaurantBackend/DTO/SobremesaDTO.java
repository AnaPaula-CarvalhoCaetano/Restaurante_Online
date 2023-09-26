package com.api.OnlineRestaurantBackend.DTO;

public class SobremesaDTO {

	private Long id;
	private String nome;
	private double preco;

	public SobremesaDTO() {
		super();
	}

	public SobremesaDTO(Long id, String nome, double preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public double getPreco() {
		return preco;
	}

}
