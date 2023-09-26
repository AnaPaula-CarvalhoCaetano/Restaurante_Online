package com.api.OnlineRestaurantBackend.DTO;

import java.util.List;

public class CarrinhoDTO {
    private Long id;
    private List<ItemCarrinhoDTO> itens;

    public CarrinhoDTO() {
    }

    public CarrinhoDTO(Long id, List<ItemCarrinhoDTO> itens) {
        this.id = id;
        this.itens = itens;
    }

    public Long getId() {
        return id;
    }

    public List<ItemCarrinhoDTO> getItens() {
        return itens;
    }

}
