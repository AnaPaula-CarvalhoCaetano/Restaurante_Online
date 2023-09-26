package com.api.OnlineRestaurantBackend.DTO;

public class BebidaDTO {

	private Long id;
	private String nome;
	private double preco;
	private String descricao;

	public BebidaDTO() {

	}

	public BebidaDTO(Long id, String nome, double preco, String descricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
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

	public String getDescricao() {
		return descricao;
	}

}
