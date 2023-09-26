package com.api.OnlineRestaurantBackend.Service;

import java.util.List;

import com.api.OnlineRestaurantBackend.DTO.PratoDTO;

public interface PratoService {
	
	PratoDTO criarPrato(PratoDTO pratoDTO);
	
	PratoDTO atualizarPrato(Long id, PratoDTO pratoDTO);
	
	void excluirPrato(Long id);
	
	PratoDTO buscarPratoPorId(Long id);
	
	List<PratoDTO> listarPratos();
	
	

}
