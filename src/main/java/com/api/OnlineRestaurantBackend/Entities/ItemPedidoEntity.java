package com.api.OnlineRestaurantBackend.Entities;

import com.api.OnlineRestaurantBackend.Enum.StatusPedido;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;


@Entity
@Data
public class ItemPedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private PedidoEntity pedido;

    @ManyToOne
    private ProdutoEntity produto; 

    private int quantidade;
    private double precoUnitario;
    
	public void setStatus(StatusPedido novoStatus) {
		
	}

}
