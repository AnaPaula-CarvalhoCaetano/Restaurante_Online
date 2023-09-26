package com.api.OnlineRestaurantBackend.Service;

import java.util.List;

import com.api.OnlineRestaurantBackend.DTO.CarrinhoDTO;
import com.api.OnlineRestaurantBackend.Entities.ItemCarrinhoEntity;

public interface CarrinhoService {

	CarrinhoDTO atualizarCarrinho(Long id, CarrinhoDTO carrinhoDTO);

	void adicionarItemAoCarrinho(Long carrinhoId, ItemCarrinhoEntity item);

	void removerItemDoCarrinho(Long carrinhoId, Long itemId);

	List<ItemCarrinhoEntity> listarItensNoCarrinho(Long carrinhoId);

	void limparCarrinho(Long carrinhoId);

	double calcularValorTotalDoCarrinho(Long carrinhoId);

}
