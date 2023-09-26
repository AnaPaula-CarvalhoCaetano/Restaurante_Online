package com.api.OnlineRestaurantBackend.DTO;

import java.time.LocalDate;
import java.util.List;

public class PedidoDTO {
    private Long id;
    private List<ItemPedidoDTO> itens;
    private LocalDate dataPedido;
    private String status;
    private String enderecoEntrega;
    private String metodoPagamento;

    public PedidoDTO() {
    }

    public PedidoDTO(Long id, List<ItemPedidoDTO> itens, LocalDate dataPedido, String status, String enderecoEntrega, String metodoPagamento) {
        this.id = id;
        this.itens = itens;
        this.dataPedido = dataPedido;
        this.status = status;
        this.enderecoEntrega = enderecoEntrega;
        this.metodoPagamento = metodoPagamento;
    }

    public Long getId() {
        return id;
    }

    public List<ItemPedidoDTO> getItens() {
        return itens;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public String getStatus() {
        return status;
    }

    public String getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public String getMetodoPagamento() {
        return metodoPagamento;
    }
}
