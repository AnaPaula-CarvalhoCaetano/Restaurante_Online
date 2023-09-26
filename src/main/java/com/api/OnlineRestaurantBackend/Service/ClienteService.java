package com.api.OnlineRestaurantBackend.Service;

import java.util.List;
import com.api.OnlineRestaurantBackend.DTO.ClienteDTO;

public interface ClienteService {

	ClienteDTO criarCliente(ClienteDTO clienteDTO);
	
	ClienteDTO atualizarCliente(Long id, ClienteDTO clienteDTO);

	void excluirCliente(Long id);

	ClienteDTO buscarClientePorId(Long id);

	List<ClienteDTO> listarClientes();

}
