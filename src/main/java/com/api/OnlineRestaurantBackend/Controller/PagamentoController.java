package com.api.OnlineRestaurantBackend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.api.OnlineRestaurantBackend.Entities.PagamentoEntity;
import com.api.OnlineRestaurantBackend.Service.PagamentoService;

import java.util.List;

@RestController
@RequestMapping("/api/pagamento")
public class PagamentoController {

	private final PagamentoService pagamentoService;

	@Autowired
	public PagamentoController(PagamentoService pagamentoService) {
		this.pagamentoService = pagamentoService;
	}

	@PostMapping
	public PagamentoEntity processarPagamento(@RequestBody PagamentoEntity pagamentoEntity) {
		return pagamentoService.processarPagamento(pagamentoEntity);
	}

	@GetMapping("/listar")
	public List<PagamentoEntity> listarPagamentos() {
		return pagamentoService.listarPagamentos();
	}

	@GetMapping("/{pagamentoId}")
	public PagamentoEntity buscarPagamentoPorId(@PathVariable Long pagamentoId) {
		return pagamentoService.buscarPagamentoPorId(pagamentoId);
	}

	@GetMapping("/calcular-valor-total-pedido/{pedidoId}")
	public double calcularValorTotalDosPagamentosParaPedido(@PathVariable Long pedidoId) {
		return pagamentoService.calcularValorTotalDosPagamentosParaPedido(pedidoId);
	}
}
