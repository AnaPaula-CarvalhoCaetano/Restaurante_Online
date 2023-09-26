package com.api.OnlineRestaurantBackend.Service;

import java.util.List;

import com.api.OnlineRestaurantBackend.DTO.BebidaDTO;

public interface BebidaService {

	BebidaDTO criarBebida(BebidaDTO bebidaDTO);

	BebidaDTO atualizarBebida(Long id, BebidaDTO bebidaDTO);

	void excluirBebida(Long id);

	BebidaDTO buscarBebidaPorId(Long id);

	List<BebidaDTO> listarBebidas();

}
