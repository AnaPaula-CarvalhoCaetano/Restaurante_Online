package com.api.OnlineRestaurantBackend.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class ItemCarrinhoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private CarrinhoEntity carrinho;

	@ManyToOne
	private PratoEntity prato;

	@ManyToOne
	private SobremesaEntity sobremesa;

	@ManyToOne
	private BebidaEntity bebida;

	private int quantidade;
	
	private double precoUnitario;

}
