package com.api.OnlineRestaurantBackend.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.OnlineRestaurantBackend.Entities.ItemPedidoEntity;
import com.api.OnlineRestaurantBackend.Entities.PedidoEntity;
import com.api.OnlineRestaurantBackend.Enum.StatusPedido;
import com.api.OnlineRestaurantBackend.Exception.PedidoNaoEncontradoException;
import com.api.OnlineRestaurantBackend.Repository.PedidoRepository;
import com.api.OnlineRestaurantBackend.Service.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService {

	private final PedidoRepository pedidoRepository;

	@Autowired
	public PedidoServiceImpl(PedidoRepository pedidoRepository) {
		this.pedidoRepository = pedidoRepository;
	}

	@Override
	public PedidoEntity criarPedido(PedidoEntity pedido) {
		return pedidoRepository.save(pedido);
	}

	@Override
	public PedidoEntity atualizarStatusDoPedido(Long pedidoId, StatusPedido novoStatus) {
		Optional<PedidoEntity> existingPedido = pedidoRepository.findById(pedidoId);
		if (existingPedido.isPresent()) {
			PedidoEntity pedido = existingPedido.get();
			pedido.setStatus(novoStatus);
			pedidoRepository.save(pedido);
			return pedido;
		} else {
			throw new PedidoNaoEncontradoException("Pedido não encontrado com o ID: " + pedidoId);
		}
	}

	@Override
	public List<PedidoEntity> listarPedidos() {
		return pedidoRepository.findAll();
	}

	@Override
	public PedidoEntity buscarPedidoPorId(Long pedidoId) {
		Optional<PedidoEntity> pedido = pedidoRepository.findById(pedidoId);
		if (pedido.isPresent()) {
			return pedido.get();
		} else {
			throw new PedidoNaoEncontradoException("Pedido não encontrado com o ID: " + pedidoId);
		}
	}

	@Override
	public double calcularValorTotalDoPedido(Long pedidoId) {
		Optional<PedidoEntity> pedido = pedidoRepository.findById(pedidoId);
		if (pedido.isPresent()) {
			PedidoEntity pedidoEntity = pedido.get();
			List<ItemPedidoEntity> itens = pedidoEntity.getItens();
			double valorTotal = itens.stream().mapToDouble(item -> item.getPrecoUnitario() * item.getQuantidade())
					.sum();
			return valorTotal;
		} else {
			throw new PedidoNaoEncontradoException("Pedido não encontrado com o ID: " + pedidoId);
		}
	}

	@Override
	public void adicionarItensAoPedido(Long pedidoId, List<ItemPedidoEntity> itens) {
		Optional<PedidoEntity> existingPedido = pedidoRepository.findById(pedidoId);
		if (existingPedido.isPresent()) {
			PedidoEntity pedidoEntity = existingPedido.get();
			List<ItemPedidoEntity> pedidoItens = pedidoEntity.getItens();
			pedidoItens.addAll(itens);
			pedidoEntity.setItens(pedidoItens);
			pedidoRepository.save(pedidoEntity);
		} else {
			throw new PedidoNaoEncontradoException("Pedido não encontrado com o ID: " + pedidoId);
		}
	}

	@Override
	public void removerItensDoPedido(Long pedidoId, List<ItemPedidoEntity> itens) {
		Optional<PedidoEntity> existingPedido = pedidoRepository.findById(pedidoId);
		if (existingPedido.isPresent()) {
			PedidoEntity pedidoEntity = existingPedido.get();
			List<ItemPedidoEntity> pedidoItens = pedidoEntity.getItens();
			pedidoItens.removeAll(itens);
			pedidoEntity.setItens(pedidoItens);
			pedidoRepository.save(pedidoEntity);
		} else {
			throw new PedidoNaoEncontradoException("Pedido não encontrado com o ID: " + pedidoId);
		}
	}
}
