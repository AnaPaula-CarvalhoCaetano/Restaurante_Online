package com.api.OnlineRestaurantBackend.Service;

import java.util.List;

import com.api.OnlineRestaurantBackend.DTO.CategoriaDTO;

public interface CategoriaService {
	
	CategoriaDTO criarCategoria(CategoriaDTO categoriaDTO);
	
	CategoriaDTO atualizarCategoria(Long id, CategoriaDTO categoriaDTO);
	
	void excluirCategoria(Long id);
	
	CategoriaDTO buscarCategoriaPorId(Long id);
	
	List<CategoriaDTO> listarCategorias();

}
