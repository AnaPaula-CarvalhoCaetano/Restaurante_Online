package com.api.OnlineRestaurantBackend.ServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.OnlineRestaurantBackend.DTO.ClienteDTO;
import com.api.OnlineRestaurantBackend.Repository.ClienteRepository;
import com.api.OnlineRestaurantBackend.Service.ClienteService;
import com.api.OnlineRestaurantBackend.Entities.ClienteEntity;
import com.api.OnlineRestaurantBackend.Exception.ClienteNaoEncontradoException;

@Service
public class ClienteServiceImpl implements ClienteService {

	private final ClienteRepository clienteRepository;

	@Autowired
	public ClienteServiceImpl(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	@Override
	public ClienteDTO criarCliente(ClienteDTO clienteDTO) {
		ClienteEntity clienteEntity = new ClienteEntity();
		BeanUtils.copyProperties(clienteDTO, clienteEntity);

		clienteEntity = clienteRepository.save(clienteEntity);

		ClienteDTO resultDTO = new ClienteDTO();
		BeanUtils.copyProperties(clienteEntity, resultDTO);

		return resultDTO;
	}

	@Override
	public ClienteDTO atualizarCliente(Long id, ClienteDTO clienteDTO) {
		Optional<ClienteEntity> existingCliente = clienteRepository.findById(id);
		if (existingCliente.isPresent()) {
			ClienteEntity clienteEntity = existingCliente.get();
			BeanUtils.copyProperties(clienteDTO, clienteEntity);

			clienteEntity = clienteRepository.save(clienteEntity);

			ClienteDTO resultDTO = new ClienteDTO();
			BeanUtils.copyProperties(clienteEntity, resultDTO);

			return resultDTO;
		} else {
			throw new ClienteNaoEncontradoException("Cliente não encontrado com o ID: " + id);
		}
	}

	@Override
	public void excluirCliente(Long id) {
		clienteRepository.deleteById(id);
	}

	@Override
	public ClienteDTO buscarClientePorId(Long id) {
		Optional<ClienteEntity> clienteEntity = clienteRepository.findById(id);
		if (clienteEntity.isPresent()) {
			ClienteDTO clienteDTO = new ClienteDTO();
			BeanUtils.copyProperties(clienteEntity.get(), clienteDTO);
			return clienteDTO;
		} else {
			throw new ClienteNaoEncontradoException("Cliente não encontrado com o ID: " + id);
		}
	}

	@Override
	public List<ClienteDTO> listarClientes() {
		List<ClienteEntity> clienteEntityList = clienteRepository.findAll();

		List<ClienteDTO> clienteDTOList = clienteEntityList.stream().map(clienteEntity -> {
			ClienteDTO clienteDTO = new ClienteDTO();
			BeanUtils.copyProperties(clienteEntity, clienteDTO);
			return clienteDTO;
		}).collect(Collectors.toList());

		return clienteDTOList;
	}
}
