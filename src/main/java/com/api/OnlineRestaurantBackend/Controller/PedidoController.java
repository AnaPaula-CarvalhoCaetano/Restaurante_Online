package com.api.OnlineRestaurantBackend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.api.OnlineRestaurantBackend.Entities.ItemPedidoEntity;
import com.api.OnlineRestaurantBackend.Entities.PedidoEntity;
import com.api.OnlineRestaurantBackend.Enum.StatusPedido;
import com.api.OnlineRestaurantBackend.Service.PedidoService;

import java.util.List;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {

	private final PedidoService pedidoService;

	@Autowired
	public PedidoController(PedidoService pedidoService) {
		this.pedidoService = pedidoService;
	}

	@PostMapping
	public PedidoEntity criarPedido(@RequestBody PedidoEntity pedido) {
		return pedidoService.criarPedido(pedido);
	}

	@PutMapping("/{pedidoId}/status")
	public PedidoEntity atualizarStatusDoPedido(@PathVariable Long pedidoId, @RequestBody StatusPedido novoStatus) {
		return pedidoService.atualizarStatusDoPedido(pedidoId, novoStatus);
	}

	@GetMapping("/listar")
	public List<PedidoEntity> listarPedidos() {
		return pedidoService.listarPedidos();
	}

	@GetMapping("/{pedidoId}")
	public PedidoEntity buscarPedidoPorId(@PathVariable Long pedidoId) {
		return pedidoService.buscarPedidoPorId(pedidoId);
	}

	@GetMapping("/{pedidoId}/calcular-valor")
	public double calcularValorTotalDoPedido(@PathVariable Long pedidoId) {
		return pedidoService.calcularValorTotalDoPedido(pedidoId);
	}

	@PostMapping("/{pedidoId}/adicionar-itens")
	public void adicionarItensAoPedido(@PathVariable Long pedidoId, @RequestBody List<ItemPedidoEntity> itens) {
		pedidoService.adicionarItensAoPedido(pedidoId, itens);
	}

	@PostMapping("/{pedidoId}/remover-itens")
	public void removerItensDoPedido(@PathVariable Long pedidoId, @RequestBody List<ItemPedidoEntity> itens) {
		pedidoService.removerItensDoPedido(pedidoId, itens);
	}
}
