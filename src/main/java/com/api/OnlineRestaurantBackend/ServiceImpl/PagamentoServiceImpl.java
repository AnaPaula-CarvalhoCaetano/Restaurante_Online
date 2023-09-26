package com.api.OnlineRestaurantBackend.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.OnlineRestaurantBackend.Entities.PagamentoEntity;
import com.api.OnlineRestaurantBackend.Entities.PedidoEntity;
import com.api.OnlineRestaurantBackend.Exception.PagamentoNaoEncontradoException;
import com.api.OnlineRestaurantBackend.Exception.PedidoNaoEncontradoException;
import com.api.OnlineRestaurantBackend.Repository.PagamentoRepository;
import com.api.OnlineRestaurantBackend.Service.PagamentoService;
import com.api.OnlineRestaurantBackend.Repository.PedidoRepository;

@Service
public class PagamentoServiceImpl implements PagamentoService {

	private final PagamentoRepository pagamentoRepository;
	private final PedidoRepository pedidoRepository;

	@Autowired
	public PagamentoServiceImpl(PagamentoRepository pagamentoRepository, PedidoRepository pedidoRepository) {
		this.pagamentoRepository = pagamentoRepository;
		this.pedidoRepository = pedidoRepository;
	}

	@Override
	public PagamentoEntity processarPagamento(PagamentoEntity pagamento) {
		PagamentoEntity pagamentoEntity = new PagamentoEntity();
		BeanUtils.copyProperties(pagamento, pagamentoEntity);

		pagamentoEntity = pagamentoRepository.save(pagamentoEntity);

		return pagamentoEntity;
	}

	@Override
	public List<PagamentoEntity> listarPagamentos() {
		return pagamentoRepository.findAll();
	}

	@Override
	public PagamentoEntity buscarPagamentoPorId(Long pagamentoId) {
		Optional<PagamentoEntity> pagamentoEntity = pagamentoRepository.findById(pagamentoId);
		if (pagamentoEntity.isPresent()) {
			return pagamentoEntity.get();
		} else {
			throw new PagamentoNaoEncontradoException("Pagamento não encontrado com o ID: " + pagamentoId);
		}
	}

	@Override
	public double calcularValorTotalDosPagamentosParaPedido(Long pedidoId) {
		Optional<PedidoEntity> pedidoEntityOptional = pedidoRepository.findById(pedidoId);

		if (pedidoEntityOptional.isPresent()) {
			PedidoEntity pedido = pedidoEntityOptional.get();
			List<PagamentoEntity> pagamentos = pedido.getPagamentos();

			double valorTotal = pagamentos.stream().mapToDouble(PagamentoEntity::getValor).sum();

			return valorTotal;
		} else {
			throw new PedidoNaoEncontradoException("Pedido não encontrado com o ID: " + pedidoId);
		}
	}

}
