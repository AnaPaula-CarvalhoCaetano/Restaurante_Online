package com.api.OnlineRestaurantBackend.Service;

import java.util.List;

import com.api.OnlineRestaurantBackend.Entities.ItemPedidoEntity;
import com.api.OnlineRestaurantBackend.Entities.PedidoEntity;
import com.api.OnlineRestaurantBackend.Enum.StatusPedido;

public interface PedidoService {

	PedidoEntity criarPedido(PedidoEntity pedido);

	PedidoEntity atualizarStatusDoPedido(Long pedidoId, StatusPedido novoStatus);

	List<PedidoEntity> listarPedidos();

	PedidoEntity buscarPedidoPorId(Long pedidoId);

	double calcularValorTotalDoPedido(Long pedidoId);

	void adicionarItensAoPedido(Long pedidoId, List<ItemPedidoEntity> itens);

	void removerItensDoPedido(Long pedidoId, List<ItemPedidoEntity> itens);
}
