package com.api.OnlineRestaurantBackend.DTO;

public class ItemCarrinhoDTO {
    private Long id;
    private Long carrinhoId;
    private Long pratoId;
    private Long sobremesaId;
    private Long bebidaId;
    private int quantidade;
    private double precoUnitario;

    public ItemCarrinhoDTO() {
    }

    public ItemCarrinhoDTO(Long id, Long carrinhoId, Long pratoId, Long sobremesaId, Long bebidaId, int quantidade, double precoUnitario) {
        this.id = id;
        this.carrinhoId = carrinhoId;
        this.pratoId = pratoId;
        this.sobremesaId = sobremesaId;
        this.bebidaId = bebidaId;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    public Long getId() {
        return id;
    }

    public Long getCarrinhoId() {
        return carrinhoId;
    }

    public Long getPratoId() {
        return pratoId;
    }

    public Long getSobremesaId() {
        return sobremesaId;
    }

    public Long getBebidaId() {
        return bebidaId;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }
}
