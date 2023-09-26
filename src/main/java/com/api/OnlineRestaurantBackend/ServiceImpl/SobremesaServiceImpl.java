package com.api.OnlineRestaurantBackend.ServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.OnlineRestaurantBackend.Entities.SobremesaEntity;
import com.api.OnlineRestaurantBackend.Exception.SobremesaNaoEncontradaException;
import com.api.OnlineRestaurantBackend.DTO.SobremesaDTO;
import com.api.OnlineRestaurantBackend.Repository.SobremesaRepository;
import com.api.OnlineRestaurantBackend.Service.SobremesaService;


@Service
public class SobremesaServiceImpl implements SobremesaService{
	
	
	private final SobremesaRepository sobremesaRepository;
	
	
	@Autowired
	public SobremesaServiceImpl(SobremesaRepository sobremesaRepository) {
		this.sobremesaRepository = sobremesaRepository;
	}


	@Override
	public SobremesaDTO criarSobremesa(SobremesaDTO sobremesaDTO) {
		SobremesaEntity sobremesaEntity = new SobremesaEntity();
		BeanUtils.copyProperties(sobremesaDTO, sobremesaEntity);
		sobremesaEntity = sobremesaRepository.save(sobremesaEntity);
		SobremesaDTO resultDTO = new SobremesaDTO();
		BeanUtils.copyProperties(sobremesaEntity, resultDTO);
		
		return resultDTO;
	}


	@Override
	public SobremesaDTO atualizarSobremsa(Long id, SobremesaDTO sobremesaDTO) {
		Optional<SobremesaEntity> existingSobremesa = sobremesaRepository.findById(id);
		if(existingSobremesa.isPresent()) {
			SobremesaEntity sobremesaEntity = existingSobremesa.get();
			BeanUtils.copyProperties(sobremesaDTO, sobremesaEntity);
			sobremesaEntity = sobremesaRepository.save(sobremesaEntity);
			SobremesaDTO resultDTO = new SobremesaDTO();
			BeanUtils.copyProperties(sobremesaEntity, resultDTO);
			
			return resultDTO;
			
		}else {
			throw new SobremesaNaoEncontradaException("Sobremesa não encontrada com o ID: " + id);
		}
	}


	@Override
	public void excluirSobremesa(Long id) {
		sobremesaRepository.deleteById(id);
		
	}


	@Override
	public SobremesaDTO buscarSobremesaPorId(Long id) {
		Optional<SobremesaEntity> sobremesaEntity = sobremesaRepository.findById(id);
		if(sobremesaEntity.isPresent()) {
			SobremesaDTO sobremesaDTO = new SobremesaDTO();
			BeanUtils.copyProperties(sobremesaEntity.get(), sobremesaDTO);
			return sobremesaDTO;		
		}else {
			throw new SobremesaNaoEncontradaException("Sobremesa não encontrada com o ID: " + id);
		}
		
	}


	@Override
	public List<SobremesaDTO> listarSobremesas() {
		List<SobremesaEntity> sobremesaEntityList = sobremesaRepository.findAll();
		
		return sobremesaEntityList.stream()
				.map(sobremesaEntity -> {
					SobremesaDTO sobremesaDTO = new SobremesaDTO();
					BeanUtils.copyProperties(sobremesaEntity, sobremesaDTO);
					return sobremesaDTO;
				})

				.collect(Collectors.toList());
	}
	
	
}