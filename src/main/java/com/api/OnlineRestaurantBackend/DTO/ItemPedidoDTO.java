package com.api.OnlineRestaurantBackend.DTO;

public class ItemPedidoDTO {
    private Long id;
    private Long pedidoId;
    private Long produtoId;
    private int quantidade;
    private double precoUnitario;

    public ItemPedidoDTO() {
    }

    public ItemPedidoDTO(Long id, Long pedidoId, Long produtoId, int quantidade, double precoUnitario) {
        this.id = id;
        this.pedidoId = pedidoId;
        this.produtoId = produtoId;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    public Long getId() {
        return id;
    }

    public Long getPedidoId() {
        return pedidoId;
    }

    public Long getProdutoId() {
        return produtoId;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }
}
