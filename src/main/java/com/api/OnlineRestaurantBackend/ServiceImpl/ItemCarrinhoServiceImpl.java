package com.api.OnlineRestaurantBackend.ServiceImpl;

import com.api.OnlineRestaurantBackend.DTO.ItemCarrinhoDTO;
import com.api.OnlineRestaurantBackend.Entities.ItemCarrinhoEntity;
import com.api.OnlineRestaurantBackend.Exception.ItemCarrinhoNaoEncontradoException;
import com.api.OnlineRestaurantBackend.Repository.ItemCarrinhoRepository;
import com.api.OnlineRestaurantBackend.Service.ItemCarrinhoService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItemCarrinhoServiceImpl implements ItemCarrinhoService {

	private final ItemCarrinhoRepository itemCarrinhoRepository;

	@Autowired
	public ItemCarrinhoServiceImpl(ItemCarrinhoRepository itemCarrinhoRepository) {
		this.itemCarrinhoRepository = itemCarrinhoRepository;
	}

	@Override
	public ItemCarrinhoDTO criarItemCarrinho(ItemCarrinhoDTO itemCarrinhoDTO) {
		ItemCarrinhoEntity itemCarrinhoEntity = new ItemCarrinhoEntity();
		BeanUtils.copyProperties(itemCarrinhoDTO, itemCarrinhoEntity);
		itemCarrinhoEntity = itemCarrinhoRepository.save(itemCarrinhoEntity);
		ItemCarrinhoDTO resultDTO = new ItemCarrinhoDTO();
		BeanUtils.copyProperties(itemCarrinhoEntity, resultDTO);
		return resultDTO;
	}

	@Override
	public ItemCarrinhoDTO atualizarItemCarrinho(Long id, ItemCarrinhoDTO itemCarrinhoDTO) {
		Optional<ItemCarrinhoEntity> existingItemCarrinho = itemCarrinhoRepository.findById(id);
		if (existingItemCarrinho.isPresent()) {
			ItemCarrinhoEntity itemCarrinhoEntity = existingItemCarrinho.get();
			BeanUtils.copyProperties(itemCarrinhoDTO, itemCarrinhoEntity);
			itemCarrinhoEntity = itemCarrinhoRepository.save(itemCarrinhoEntity);
			ItemCarrinhoDTO resultDTO = new ItemCarrinhoDTO();
			BeanUtils.copyProperties(itemCarrinhoEntity, resultDTO);
			return resultDTO;
		} else {
			throw new ItemCarrinhoNaoEncontradoException("Item do carrinho não encontrado com o ID: " + id);
		}
	}

	@Override
	public void excluirItemCarrinho(Long id) {
		itemCarrinhoRepository.deleteById(id);
	}

	@Override
	public ItemCarrinhoDTO buscarItemCarrinhoPorId(Long id) {
		Optional<ItemCarrinhoEntity> itemCarrinhoEntity = itemCarrinhoRepository.findById(id);
		if (itemCarrinhoEntity.isPresent()) {
			ItemCarrinhoDTO itemCarrinhoDTO = new ItemCarrinhoDTO();
			BeanUtils.copyProperties(itemCarrinhoEntity.get(), itemCarrinhoDTO);
			return itemCarrinhoDTO;
		} else {
			throw new ItemCarrinhoNaoEncontradoException("Item do carrinho não encontrado com o ID: " + id);
		}
	}

	@Override
	public List<ItemCarrinhoDTO> listarItensCarrinho() {
		List<ItemCarrinhoEntity> itemCarrinhoEntities = itemCarrinhoRepository.findAll();
		return itemCarrinhoEntities.stream().map(itemCarrinhoEntity -> {
			ItemCarrinhoDTO itemCarrinhoDTO = new ItemCarrinhoDTO();
			BeanUtils.copyProperties(itemCarrinhoEntity, itemCarrinhoDTO);
			return itemCarrinhoDTO;
		}).collect(Collectors.toList());
	}
}
