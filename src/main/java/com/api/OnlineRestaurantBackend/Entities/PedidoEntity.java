package com.api.OnlineRestaurantBackend.Entities;

import java.time.LocalDate;
import java.util.List;

import com.api.OnlineRestaurantBackend.Enum.MetodoPagamento;
import com.api.OnlineRestaurantBackend.Enum.StatusPedido;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class PedidoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	private List<ItemPedidoEntity> itens;

	private LocalDate dataPedido;

	@Enumerated(EnumType.STRING)
	private StatusPedido status;

	private String enderecoEntrega;

	@Enumerated(EnumType.STRING)
	private MetodoPagamento metodoPagamento;
	
	
	@OneToMany(mappedBy = "pedido")
	private List<PagamentoEntity> pagamentos;


}
