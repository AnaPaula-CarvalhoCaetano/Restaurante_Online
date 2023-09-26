package com.api.OnlineRestaurantBackend.Service;

import com.api.OnlineRestaurantBackend.DTO.ItemCarrinhoDTO;
import java.util.List;

public interface ItemCarrinhoService {

    ItemCarrinhoDTO criarItemCarrinho(ItemCarrinhoDTO itemCarrinhoDTO);

    ItemCarrinhoDTO atualizarItemCarrinho(Long id, ItemCarrinhoDTO itemCarrinhoDTO);

    void excluirItemCarrinho(Long id);

    ItemCarrinhoDTO buscarItemCarrinhoPorId(Long id);

    List<ItemCarrinhoDTO> listarItensCarrinho();
}
