package com.api.OnlineRestaurantBackend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.api.OnlineRestaurantBackend.DTO.CategoriaDTO;
import com.api.OnlineRestaurantBackend.Service.CategoriaService;

import java.util.List;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {

	private final CategoriaService categoriaService;

	@Autowired
	public CategoriaController(CategoriaService categoriaService) {
		this.categoriaService = categoriaService;
	}

	@PostMapping
	public CategoriaDTO criarCategoria(@RequestBody CategoriaDTO categoriaDTO) {
		return categoriaService.criarCategoria(categoriaDTO);
	}

	@PutMapping("/{categoriaId}")
	public CategoriaDTO atualizarCategoria(@PathVariable Long categoriaId, @RequestBody CategoriaDTO categoriaDTO) {
		return categoriaService.atualizarCategoria(categoriaId, categoriaDTO);
	}

	@DeleteMapping("/{categoriaId}")
	public void excluirCategoria(@PathVariable Long categoriaId) {
		categoriaService.excluirCategoria(categoriaId);
	}

	@GetMapping("/{categoriaId}")
	public CategoriaDTO buscarCategoriaPorId(@PathVariable Long categoriaId) {
		return categoriaService.buscarCategoriaPorId(categoriaId);
	}

	@GetMapping("/listar")
	public List<CategoriaDTO> listarCategorias() {
		return categoriaService.listarCategorias();
	}
}
