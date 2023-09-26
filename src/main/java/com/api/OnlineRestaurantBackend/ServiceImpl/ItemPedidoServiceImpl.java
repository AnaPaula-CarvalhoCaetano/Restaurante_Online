package com.api.OnlineRestaurantBackend.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.OnlineRestaurantBackend.Entities.ItemPedidoEntity;
import com.api.OnlineRestaurantBackend.Enum.StatusPedido;
import com.api.OnlineRestaurantBackend.Exception.ItemPedidoNaoEncontradoException;
import com.api.OnlineRestaurantBackend.Repository.ItemPedidoRepository;
import com.api.OnlineRestaurantBackend.Service.ItemPedidoService;

@Service
public class ItemPedidoServiceImpl implements ItemPedidoService {

    private final ItemPedidoRepository itemPedidoRepository;

    @Autowired
    public ItemPedidoServiceImpl(ItemPedidoRepository itemPedidoRepository) {
        this.itemPedidoRepository = itemPedidoRepository;
    }

    @Override
    public ItemPedidoEntity criarItemPedido(ItemPedidoEntity itemPedido) {
        ItemPedidoEntity itemPedidoEntity = new ItemPedidoEntity();
        BeanUtils.copyProperties(itemPedido, itemPedidoEntity);

        itemPedidoEntity = itemPedidoRepository.save(itemPedidoEntity);

        return itemPedidoEntity;
    }

    @Override
    public ItemPedidoEntity atualizarStatusDoItemPedido(Long itemPedidoId, StatusPedido novoStatus) {
        Optional<ItemPedidoEntity> existingItemPedido = itemPedidoRepository.findById(itemPedidoId);
        if (existingItemPedido.isPresent()) {
            ItemPedidoEntity itemPedidoEntity = existingItemPedido.get();
            itemPedidoEntity.setStatus(novoStatus);

            itemPedidoEntity = itemPedidoRepository.save(itemPedidoEntity);

            return itemPedidoEntity;
        } else {
            throw new ItemPedidoNaoEncontradoException("Item de pedido não encontrado com o ID: " + itemPedidoId);
        }
    }

    @Override
    public List<ItemPedidoEntity> listarItensDePedido() {
        return itemPedidoRepository.findAll();
    }

    @Override
    public ItemPedidoEntity buscarItemPedidoPorId(Long itemPedidoId) {
        Optional<ItemPedidoEntity> itemPedidoEntity = itemPedidoRepository.findById(itemPedidoId);
        if (itemPedidoEntity.isPresent()) {
            return itemPedidoEntity.get();
        } else {
            throw new ItemPedidoNaoEncontradoException("Item de pedido não encontrado com o ID: " + itemPedidoId);
        }
    }

    @Override
    public double calcularValorTotalDoItemPedido(Long itemPedidoId) {
        Optional<ItemPedidoEntity> itemPedidoEntity = itemPedidoRepository.findById(itemPedidoId);
        if (itemPedidoEntity.isPresent()) {
            double valorTotal = itemPedidoEntity.get().getPrecoUnitario() * itemPedidoEntity.get().getQuantidade();
            return valorTotal;
        } else {
            throw new ItemPedidoNaoEncontradoException("Item de pedido não encontrado com o ID: " + itemPedidoId);
        }
    }
}
