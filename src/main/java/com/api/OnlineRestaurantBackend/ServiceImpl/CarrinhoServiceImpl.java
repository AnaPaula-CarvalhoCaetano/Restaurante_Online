package com.api.OnlineRestaurantBackend.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.OnlineRestaurantBackend.DTO.CarrinhoDTO;
import com.api.OnlineRestaurantBackend.Entities.CarrinhoEntity;
import com.api.OnlineRestaurantBackend.Entities.ItemCarrinhoEntity;
import com.api.OnlineRestaurantBackend.Exception.CarrinhoNaoEncontradoException;
import com.api.OnlineRestaurantBackend.Repository.CarrinhoRepository;
import com.api.OnlineRestaurantBackend.Service.CarrinhoService;

@Service
public class CarrinhoServiceImpl implements CarrinhoService {

	private final CarrinhoRepository carrinhoRepository;

	@Autowired
	public CarrinhoServiceImpl(CarrinhoRepository carrinhoRepository) {
		this.carrinhoRepository = carrinhoRepository;
	}

	@Override
	public void adicionarItemAoCarrinho(Long carrinhoId, ItemCarrinhoEntity item) {
		Optional<CarrinhoEntity> carrinho = carrinhoRepository.findById(carrinhoId);
		if (carrinho.isPresent()) {
			CarrinhoEntity carrinhoEntity = carrinho.get();
			List<ItemCarrinhoEntity> itens = carrinhoEntity.getItens();
			itens.add(item);
			carrinhoEntity.setItens(itens);
			carrinhoRepository.save(carrinhoEntity);
		} else {
			throw new CarrinhoNaoEncontradoException("Carrinho não encontrado com o ID: " + carrinhoId);
		}
	}

	@Override
	public CarrinhoDTO atualizarCarrinho(Long carrinhoId, CarrinhoDTO carrinhoDTO) {
		Optional<CarrinhoEntity> existingCarrinho = carrinhoRepository.findById(carrinhoId);
		if (existingCarrinho.isPresent()) {
			CarrinhoEntity carrinhoEntity = existingCarrinho.get();
			carrinhoEntity.setId(carrinhoDTO.getId());
			carrinhoEntity = carrinhoRepository.save(carrinhoEntity);
			CarrinhoDTO resultDTO = new CarrinhoDTO();
			BeanUtils.copyProperties(carrinhoEntity, resultDTO);
			return resultDTO;
		} else {
			throw new CarrinhoNaoEncontradoException("Carrinho não encontrado com o ID: " + carrinhoId);
		}

	}

	@Override
	public void removerItemDoCarrinho(Long carrinhoId, Long itemId) {
		Optional<CarrinhoEntity> existingCarrinho = carrinhoRepository.findById(carrinhoId);
		if (existingCarrinho.isPresent()) {
			CarrinhoEntity carrinhoEntity = existingCarrinho.get();
			List<ItemCarrinhoEntity> itens = carrinhoEntity.getItens();
			itens.removeIf(item -> item.getId().equals(itemId));
			carrinhoEntity.setItens(itens);
			carrinhoRepository.save(carrinhoEntity);
		} else {
			throw new CarrinhoNaoEncontradoException("Carrinho não encontrado com o ID: " + carrinhoId);
		}
	}

	@Override
	public List<ItemCarrinhoEntity> listarItensNoCarrinho(Long carrinhoId) {
		Optional<CarrinhoEntity> existingCarrinho = carrinhoRepository.findById(carrinhoId);
		if (existingCarrinho.isPresent()) {
			CarrinhoEntity carrinhoEntity = existingCarrinho.get();
			return carrinhoEntity.getItens();
		} else {
			throw new CarrinhoNaoEncontradoException("Carrinho não encontrado com o ID: " + carrinhoId);
		}
	}

	@Override
	public void limparCarrinho(Long carrinhoId) {
		Optional<CarrinhoEntity> existingCarrinho = carrinhoRepository.findById(carrinhoId);
		if (existingCarrinho.isPresent()) {
			CarrinhoEntity carrinhoEntity = existingCarrinho.get();
			if (carrinhoEntity.getItens() != null) {
				carrinhoEntity.getItens().clear();
			}
			carrinhoRepository.save(carrinhoEntity);
		} else {
			throw new CarrinhoNaoEncontradoException("Carrinho não encontrado com o ID: " + carrinhoId);
		}
	}

	@Override
	public double calcularValorTotalDoCarrinho(Long carrinhoId) {
		Optional<CarrinhoEntity> existingCarrinho = carrinhoRepository.findById(carrinhoId);
		if (existingCarrinho.isPresent()) {
			CarrinhoEntity carrinhoEntity = existingCarrinho.get();
			List<ItemCarrinhoEntity> itens = carrinhoEntity.getItens();
			double valorTotal = 0.0;
			for (ItemCarrinhoEntity item : itens) {
				valorTotal += item.getPrecoUnitario() * item.getQuantidade();
			}
			return valorTotal;
		} else {
			throw new CarrinhoNaoEncontradoException("Carrinho não encontrado com o ID: " + carrinhoId);
		}
	}

}
