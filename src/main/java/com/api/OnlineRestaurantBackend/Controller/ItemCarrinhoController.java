package com.api.OnlineRestaurantBackend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.api.OnlineRestaurantBackend.DTO.ItemCarrinhoDTO;
import com.api.OnlineRestaurantBackend.Service.ItemCarrinhoService;

import java.util.List;

@RestController
@RequestMapping("/api/item-carrinho")
public class ItemCarrinhoController {

	private final ItemCarrinhoService itemCarrinhoService;

	@Autowired
	public ItemCarrinhoController(ItemCarrinhoService itemCarrinhoService) {
		this.itemCarrinhoService = itemCarrinhoService;
	}

	@PostMapping
	public ItemCarrinhoDTO criarItemCarrinho(@RequestBody ItemCarrinhoDTO itemCarrinhoDTO) {
		return itemCarrinhoService.criarItemCarrinho(itemCarrinhoDTO);
	}

	@PutMapping("/{itemCarrinhoId}")
	public ItemCarrinhoDTO atualizarItemCarrinho(@PathVariable Long itemCarrinhoId,
			@RequestBody ItemCarrinhoDTO itemCarrinhoDTO) {
		return itemCarrinhoService.atualizarItemCarrinho(itemCarrinhoId, itemCarrinhoDTO);
	}

	@DeleteMapping("/{itemCarrinhoId}")
	public void excluirItemCarrinho(@PathVariable Long itemCarrinhoId) {
		itemCarrinhoService.excluirItemCarrinho(itemCarrinhoId);
	}

	@GetMapping("/{itemCarrinhoId}")
	public ItemCarrinhoDTO buscarItemCarrinhoPorId(@PathVariable Long itemCarrinhoId) {
		return itemCarrinhoService.buscarItemCarrinhoPorId(itemCarrinhoId);
	}

	@GetMapping("/listar")
	public List<ItemCarrinhoDTO> listarItensCarrinho() {
		return itemCarrinhoService.listarItensCarrinho();
	}
}
