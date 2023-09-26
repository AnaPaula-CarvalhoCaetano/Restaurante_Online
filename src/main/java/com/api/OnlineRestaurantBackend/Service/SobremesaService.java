package com.api.OnlineRestaurantBackend.Service;

import java.util.List;

import com.api.OnlineRestaurantBackend.DTO.SobremesaDTO;

public interface SobremesaService {

	SobremesaDTO criarSobremesa(SobremesaDTO sobremesaDTO);

	SobremesaDTO atualizarSobremsa(Long id, SobremesaDTO sobremesaDTO);

	void excluirSobremesa(Long id);

	SobremesaDTO buscarSobremesaPorId(Long id);

	List<SobremesaDTO> listarSobremesas();

}
