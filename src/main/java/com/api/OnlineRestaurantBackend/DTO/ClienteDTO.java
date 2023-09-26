package com.api.OnlineRestaurantBackend.DTO;

public class ClienteDTO {

	private Long id;
	private String nome;
	private String email;
	private String telefone;

	public ClienteDTO() {

	}

	public ClienteDTO(Long id, String nome, String email, String telefone) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getTelefone() {
		return telefone;
	}

}
