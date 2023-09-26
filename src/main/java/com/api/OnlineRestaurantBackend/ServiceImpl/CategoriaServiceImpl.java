package com.api.OnlineRestaurantBackend.ServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.OnlineRestaurantBackend.DTO.CategoriaDTO;
import com.api.OnlineRestaurantBackend.Repository.CategoriaRepository;
import com.api.OnlineRestaurantBackend.Service.CategoriaService;
import com.api.OnlineRestaurantBackend.Entities.CategoriaEntity;
import com.api.OnlineRestaurantBackend.Exception.CategoriaNaoEncontradaException;

@Service
public class CategoriaServiceImpl implements CategoriaService{
	
	private final CategoriaRepository categoriaRepository;
	
	
	@Autowired
	public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}


	@Override
	public CategoriaDTO criarCategoria(CategoriaDTO categoriaDTO) {
		CategoriaEntity categoriaEntity = new CategoriaEntity();
		BeanUtils.copyProperties(categoriaDTO, categoriaEntity);
		categoriaEntity = categoriaRepository.save(categoriaEntity);
		CategoriaDTO resultDTO = new CategoriaDTO();
		BeanUtils.copyProperties(categoriaEntity, resultDTO);
		
		return resultDTO;
	}


	@Override
	public CategoriaDTO atualizarCategoria(Long id, CategoriaDTO categoriaDTO) {
		Optional<CategoriaEntity> existingCategoria = categoriaRepository.findById(id);
		if(existingCategoria.isPresent()) {
			CategoriaEntity categoriaEntity = existingCategoria.get();
			BeanUtils.copyProperties(categoriaDTO, categoriaEntity);
			categoriaEntity = categoriaRepository.save(categoriaEntity);
			CategoriaDTO resultDTO = new CategoriaDTO();
			BeanUtils.copyProperties(categoriaEntity, resultDTO);
			
			return resultDTO;
			
		}else {
			throw new CategoriaNaoEncontradaException("Categoria não encontrada com o ID: " + id);
		}
	}


	@Override
	public void excluirCategoria(Long id) {
		categoriaRepository.deleteById(id);
		
	}


	@Override
	public CategoriaDTO buscarCategoriaPorId(Long id) {
		Optional<CategoriaEntity> categoriaEntity = categoriaRepository.findById(id);
		if(categoriaEntity.isPresent()) {
			CategoriaDTO categoriaDTO = new CategoriaDTO();
			BeanUtils.copyProperties(categoriaEntity.get(), categoriaDTO);
			return categoriaDTO;		
		}else {
			throw new CategoriaNaoEncontradaException("Categoria não encontrada com o ID: " + id);
		}
		
	}


	@Override
	public List<CategoriaDTO> listarCategorias() {
		List<CategoriaEntity> categoriaEntityList = categoriaRepository.findAll();
		
		return categoriaEntityList.stream()
				.map(categoriaEntity -> {
					CategoriaDTO categoriaDTO = new CategoriaDTO();
					BeanUtils.copyProperties(categoriaEntity, categoriaDTO);
					return categoriaDTO;
				})

				.collect(Collectors.toList());
	}

}
