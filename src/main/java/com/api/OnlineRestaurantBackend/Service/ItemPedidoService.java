package com.api.OnlineRestaurantBackend.Service;

import java.util.List;

import com.api.OnlineRestaurantBackend.Entities.ItemPedidoEntity;
import com.api.OnlineRestaurantBackend.Enum.StatusPedido;

public interface ItemPedidoService {
	
    ItemPedidoEntity criarItemPedido(ItemPedidoEntity itemPedido);

    ItemPedidoEntity atualizarStatusDoItemPedido(Long itemPedidoId, StatusPedido novoStatus);

    List<ItemPedidoEntity> listarItensDePedido();

    ItemPedidoEntity buscarItemPedidoPorId(Long itemPedidoId);

    double calcularValorTotalDoItemPedido(Long itemPedidoId);


}
