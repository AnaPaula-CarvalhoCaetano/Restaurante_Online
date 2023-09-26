package com.api.OnlineRestaurantBackend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.api.OnlineRestaurantBackend.DTO.SobremesaDTO;
import com.api.OnlineRestaurantBackend.Service.SobremesaService;

import java.util.List;

@RestController
@RequestMapping("/api/sobremesa")
public class SobremesaController {

	private final SobremesaService sobremesaService;

	@Autowired
	public SobremesaController(SobremesaService sobremesaService) {
		this.sobremesaService = sobremesaService;
	}

	@PostMapping
	public SobremesaDTO criarSobremesa(@RequestBody SobremesaDTO sobremesaDTO) {
		return sobremesaService.criarSobremesa(sobremesaDTO);
	}

	@PutMapping("/{sobremesaId}")
	public SobremesaDTO atualizarSobremesa(@PathVariable Long sobremesaId, @RequestBody SobremesaDTO sobremesaDTO) {
		return sobremesaService.atualizarSobremsa(sobremesaId, sobremesaDTO);
	}

	@DeleteMapping("/{sobremesaId}")
	public void excluirSobremesa(@PathVariable Long sobremesaId) {
		sobremesaService.excluirSobremesa(sobremesaId);
	}

	@GetMapping("/{sobremesaId}")
	public SobremesaDTO buscarSobremesaPorId(@PathVariable Long sobremesaId) {
		return sobremesaService.buscarSobremesaPorId(sobremesaId);
	}

	@GetMapping("/listar")
	public List<SobremesaDTO> listarSobremesas() {
		return sobremesaService.listarSobremesas();
	}
}
