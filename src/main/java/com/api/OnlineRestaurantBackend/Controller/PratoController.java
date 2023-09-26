package com.api.OnlineRestaurantBackend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.api.OnlineRestaurantBackend.DTO.PratoDTO;
import com.api.OnlineRestaurantBackend.Service.PratoService;

import java.util.List;

@RestController
@RequestMapping("/api/prato")
public class PratoController {

	private final PratoService pratoService;

	@Autowired
	public PratoController(PratoService pratoService) {
		this.pratoService = pratoService;
	}

	@PostMapping
	public PratoDTO criarPrato(@RequestBody PratoDTO pratoDTO) {
		return pratoService.criarPrato(pratoDTO);
	}

	@PutMapping("/{pratoId}")
	public PratoDTO atualizarPrato(@PathVariable Long pratoId, @RequestBody PratoDTO pratoDTO) {
		return pratoService.atualizarPrato(pratoId, pratoDTO);
	}

	@DeleteMapping("/{pratoId}")
	public void excluirPrato(@PathVariable Long pratoId) {
		pratoService.excluirPrato(pratoId);
	}

	@GetMapping("/{pratoId}")
	public PratoDTO buscarPratoPorId(@PathVariable Long pratoId) {
		return pratoService.buscarPratoPorId(pratoId);
	}

	@GetMapping("/listar")
	public List<PratoDTO> listarPratos() {
		return pratoService.listarPratos();
	}
}
