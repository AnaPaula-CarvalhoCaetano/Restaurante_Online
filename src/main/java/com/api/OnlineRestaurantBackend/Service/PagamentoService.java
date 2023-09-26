package com.api.OnlineRestaurantBackend.Service;

import java.util.List;

import com.api.OnlineRestaurantBackend.Entities.PagamentoEntity;

public interface PagamentoService {

	PagamentoEntity processarPagamento(PagamentoEntity pagamento);

	List<PagamentoEntity> listarPagamentos();

	PagamentoEntity buscarPagamentoPorId(Long pagamentoId);

	double calcularValorTotalDosPagamentosParaPedido(Long pedidoId);
}
