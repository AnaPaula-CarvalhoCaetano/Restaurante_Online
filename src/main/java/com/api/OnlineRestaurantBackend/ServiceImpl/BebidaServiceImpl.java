package com.api.OnlineRestaurantBackend.ServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.OnlineRestaurantBackend.DTO.BebidaDTO;
import com.api.OnlineRestaurantBackend.Entities.BebidaEntity;
import com.api.OnlineRestaurantBackend.Exception.BebidaNaoEncontradaException;
import com.api.OnlineRestaurantBackend.Repository.BebidaRepository;
import com.api.OnlineRestaurantBackend.Service.BebidaService;


@Service
public class BebidaServiceImpl implements BebidaService{
	

	private final BebidaRepository bebidaRepository;
	
	
	@Autowired
	public BebidaServiceImpl(BebidaRepository bebidaRepository) {
		this.bebidaRepository = bebidaRepository;
	}


	@Override
	public BebidaDTO criarBebida(BebidaDTO bebidaDTO) {
		BebidaEntity bebidaEntity = new BebidaEntity();
		BeanUtils.copyProperties(bebidaDTO, bebidaEntity);
		bebidaEntity = bebidaRepository.save(bebidaEntity);
		BebidaDTO resultDTO = new BebidaDTO();
		BeanUtils.copyProperties(bebidaEntity, resultDTO);
		
		return resultDTO;
	}


	@Override
	public BebidaDTO atualizarBebida(Long id, BebidaDTO bebidaDTO) {
		Optional<BebidaEntity> existingBebida = bebidaRepository.findById(id);
		if(existingBebida.isPresent()) {
			BebidaEntity bebidaEntity = existingBebida.get();
			BeanUtils.copyProperties(bebidaDTO, bebidaEntity);
			bebidaEntity = bebidaRepository.save(bebidaEntity);
			BebidaDTO resultDTO = new BebidaDTO();
			BeanUtils.copyProperties(bebidaEntity, resultDTO);
			
			return resultDTO;
			
		}else {
			throw new BebidaNaoEncontradaException("Bebida não encontrada com o ID: " + id);
		}
	}


	@Override
	public void excluirBebida(Long id) {
		bebidaRepository.deleteById(id);
		
	}


	@Override
	public BebidaDTO buscarBebidaPorId(Long id) {
		Optional<BebidaEntity> bebidaEntity = bebidaRepository.findById(id);
		if(bebidaEntity.isPresent()) {
			BebidaDTO bebidaDTO = new BebidaDTO();
			BeanUtils.copyProperties(bebidaEntity.get(), bebidaDTO);
			return bebidaDTO;		
		}else {
			throw new BebidaNaoEncontradaException("Bebida não encontrada com o ID: " + id);
		}
		
	}


	@Override
	public List<BebidaDTO> listarBebidas() {
		List<BebidaEntity> bebidaEntityList = bebidaRepository.findAll();
		
		return bebidaEntityList.stream()
				.map(bebidaEntity -> {
					BebidaDTO bebidaDTO = new BebidaDTO();
					BeanUtils.copyProperties(bebidaEntity, bebidaDTO);
					return bebidaDTO;
				})

				.collect(Collectors.toList());
	}
	

}
