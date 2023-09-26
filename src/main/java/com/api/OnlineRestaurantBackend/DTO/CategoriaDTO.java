package com.api.OnlineRestaurantBackend.DTO;

public class CategoriaDTO {

	private Long id;
	private String nome;
	private String descricao;

	public CategoriaDTO() {

	}

	public CategoriaDTO(Long id, String nome, String descricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

}
