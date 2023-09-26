package com.api.OnlineRestaurantBackend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.api.OnlineRestaurantBackend.DTO.BebidaDTO;
import com.api.OnlineRestaurantBackend.Service.BebidaService;

import java.util.List;

@RestController
@RequestMapping("/api/bebida")
public class BebidaController {

	private final BebidaService bebidaService;

	@Autowired
	public BebidaController(BebidaService bebidaService) {
		this.bebidaService = bebidaService;
	}

	@PostMapping
	public BebidaDTO criarBebida(@RequestBody BebidaDTO bebidaDTO) {
		return bebidaService.criarBebida(bebidaDTO);
	}

	@PutMapping("/{bebidaId}")
	public BebidaDTO atualizarBebida(@PathVariable Long bebidaId, @RequestBody BebidaDTO bebidaDTO) {
		return bebidaService.atualizarBebida(bebidaId, bebidaDTO);
	}

	@DeleteMapping("/{bebidaId}")
	public void excluirBebida(@PathVariable Long bebidaId) {
		bebidaService.excluirBebida(bebidaId);
	}

	@GetMapping("/{bebidaId}")
	public BebidaDTO buscarBebidaPorId(@PathVariable Long bebidaId) {
		return bebidaService.buscarBebidaPorId(bebidaId);
	}

	@GetMapping("/listar")
	public List<BebidaDTO> listarBebidas() {
		return bebidaService.listarBebidas();
	}
}
