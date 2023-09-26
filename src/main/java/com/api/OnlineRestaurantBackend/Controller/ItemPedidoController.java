package com.api.OnlineRestaurantBackend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.api.OnlineRestaurantBackend.Entities.ItemPedidoEntity;
import com.api.OnlineRestaurantBackend.Enum.StatusPedido;
import com.api.OnlineRestaurantBackend.Service.ItemPedidoService;

import java.util.List;

@RestController
@RequestMapping("/api/item-pedido")
public class ItemPedidoController {

	private final ItemPedidoService itemPedidoService;

	@Autowired
	public ItemPedidoController(ItemPedidoService itemPedidoService) {
		this.itemPedidoService = itemPedidoService;
	}

	@PostMapping
	public ItemPedidoEntity criarItemPedido(@RequestBody ItemPedidoEntity itemPedidoEntity) {
		return itemPedidoService.criarItemPedido(itemPedidoEntity);
	}

	@PutMapping("/{itemPedidoId}")
	public ItemPedidoEntity atualizarStatusDoItemPedido(@PathVariable Long itemPedidoId,
			@RequestBody StatusPedido novoStatus) {
		return itemPedidoService.atualizarStatusDoItemPedido(itemPedidoId, novoStatus);
	}

	@GetMapping("/listar")
	public List<ItemPedidoEntity> listarItensDePedido() {
		return itemPedidoService.listarItensDePedido();
	}

	@GetMapping("/{itemPedidoId}")
	public ItemPedidoEntity buscarItemPedidoPorId(@PathVariable Long itemPedidoId) {
		return itemPedidoService.buscarItemPedidoPorId(itemPedidoId);
	}

	@GetMapping("/{itemPedidoId}/calcular-valor-total")
	public double calcularValorTotalDoItemPedido(@PathVariable Long itemPedidoId) {
		return itemPedidoService.calcularValorTotalDoItemPedido(itemPedidoId);
	}
}
