package com.api.OnlineRestaurantBackend.ServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.OnlineRestaurantBackend.DTO.PratoDTO;
import com.api.OnlineRestaurantBackend.Entities.PratoEntity;
import com.api.OnlineRestaurantBackend.Exception.PratoNaoEncontradoException;
import com.api.OnlineRestaurantBackend.Repository.PratoRepository;
import com.api.OnlineRestaurantBackend.Service.PratoService;

@Service
public class PratoServiceImpl implements PratoService {

	private final PratoRepository pratoRepository;

	@Autowired
	public PratoServiceImpl(PratoRepository pratoRepository) {
		this.pratoRepository = pratoRepository;

	}

	@Override
	public PratoDTO criarPrato(PratoDTO pratoDTO) {
		PratoEntity pratoEntity = new PratoEntity();
		BeanUtils.copyProperties(pratoDTO, pratoEntity);
		pratoEntity = pratoRepository.save(pratoEntity);
		PratoDTO resultDTO = new PratoDTO();
		BeanUtils.copyProperties(pratoEntity, resultDTO);

		return resultDTO;
	}

	@Override
	public PratoDTO atualizarPrato(Long id, PratoDTO pratoDTO) {
		Optional<PratoEntity> existingPrato = pratoRepository.findById(id);
		if (existingPrato.isPresent()) {
			PratoEntity pratoEntity = existingPrato.get();
			BeanUtils.copyProperties(pratoDTO, pratoEntity);
			pratoEntity = pratoRepository.save(pratoEntity);
			PratoDTO resultDTO = new PratoDTO();
			BeanUtils.copyProperties(pratoEntity, resultDTO);

			return resultDTO;
		} else {
			throw new PratoNaoEncontradoException("Prato não encontrado com o ID: " + id);
		}

	}

	@Override
	public void excluirPrato(Long id) {
		pratoRepository.deleteById(id);
	}

	@Override
	public PratoDTO buscarPratoPorId(Long id) {
		Optional<PratoEntity> pratoEntity = pratoRepository.findById(id);
		if (pratoEntity.isPresent()) {
			PratoDTO pratoDTO = new PratoDTO();
			BeanUtils.copyProperties(pratoEntity.get(), pratoDTO);
			return pratoDTO;
		} else {
			throw new PratoNaoEncontradoException("Prato não encontrado com o ID: " + id);
		}
	}

	@Override
	public List<PratoDTO> listarPratos() {
		List<PratoEntity> pratoEntityList = pratoRepository.findAll();

		return pratoEntityList.stream().map(pratoEntity -> {
			PratoDTO pratoDTO = new PratoDTO();
			BeanUtils.copyProperties(pratoEntity, pratoDTO);
			return pratoDTO;
		}).collect(Collectors.toList());
	}

}
