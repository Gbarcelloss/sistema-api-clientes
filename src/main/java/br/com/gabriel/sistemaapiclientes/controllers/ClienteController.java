package br.com.gabriel.sistemaapiclientes.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gabriel.sistemaapiclientes.entities.Cliente;
import br.com.gabriel.sistemaapiclientes.repositories.ClienteRepository;
import br.com.gabriel.sistemaapiclientes.sistemaapiclientes.dtos.ClientePostDTO;
import br.com.gabriel.sistemaapiclientes.sistemaapiclientes.dtos.ClientePutDTO;
import br.com.gabriel.sistemaapiclientes.sistemaapiclientes.dtos.ClienteResponseDTO;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

	@PostMapping
	public ResponseEntity<ClienteResponseDTO> post(@RequestBody @Valid ClientePostDTO dto) {

	    ClienteResponseDTO response = new ClienteResponseDTO();

	    try {
	        Cliente cliente = new Cliente();
	        cliente.setNome(dto.getNome());
	        cliente.setCpf(dto.getCpf());
	        cliente.setEmail(dto.getEmail());

	        ClienteRepository clienteRepository = new ClienteRepository();
	        clienteRepository.create(cliente);

	        response.setStatus(201); // CREATED
	        response.setMensagem("Cliente cadastrado com sucesso!");
	    } catch (Exception e) {
	        response.setStatus(500); // ERRO INTERNO
	        response.setMensagem(e.getMessage());
	    }

	    return ResponseEntity.status(response.getStatus()).body(response);
	}

	

	@PutMapping
	public ResponseEntity<ClienteResponseDTO> put(@RequestBody @Valid ClientePutDTO dto) {

	    ClienteResponseDTO response = new ClienteResponseDTO();

	    try {
	        ClienteRepository clienteRepository = new ClienteRepository();
	        Cliente cliente = clienteRepository.findById(dto.getIdCliente());

	        if (cliente != null) {
	            cliente.setNome(dto.getNome());
	            cliente.setEmail(dto.getEmail());
	            cliente.setCpf(dto.getCpf());

	            clienteRepository.update(cliente);

	            response.setStatus(200); // OK
	            response.setMensagem("Cliente atualizado com sucesso.");
	        } else {
	            response.setStatus(404); // NOT FOUND
	            response.setMensagem("Cliente não encontrado. Verifique o ID informado.");
	        }
	    } catch (Exception e) {
	        response.setStatus(500); // ERRO INTERNO
	        response.setMensagem(e.getMessage());
	    }

	    return ResponseEntity.status(response.getStatus()).body(response);
	}

	

	@DeleteMapping("{idCliente}")
	public ResponseEntity<ClienteResponseDTO> delete(@PathVariable("idCliente") Integer idCliente) {

	    ClienteResponseDTO response = new ClienteResponseDTO();

	    try {
	        ClienteRepository clienteRepository = new ClienteRepository();
	        Cliente cliente = clienteRepository.findById(idCliente);

	        if (cliente != null) {
	            clienteRepository.delete(cliente);
	            response.setStatus(200);
	            response.setMensagem("Cliente excluído com sucesso.");
	        } else {
	            response.setStatus(404);
	            response.setMensagem("Cliente não encontrado. Verifique o ID informado.");
	        }
	    } catch (Exception e) {
	        response.setStatus(500);
	        response.setMensagem(e.getMessage());
	    }

	    return ResponseEntity.status(response.getStatus()).body(response);
	}

		
		
	

	@GetMapping
	public List<Cliente> getAll() {
		
		try {
			ClienteRepository clienteRepository = new ClienteRepository();
			return clienteRepository.findAll();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
			
		}	
		}
		
		
		
		@GetMapping("{idCliente}")
		public Cliente getById(@PathVariable("idCliente") Integer idCliente) {
			
			try {
				ClienteRepository clienteRepository = new ClienteRepository();
				return clienteRepository.findById(idCliente);
				
			}catch(Exception e) {
				
				e.printStackTrace();
				
				return null;
				
				
			}
			
			
			
		}
		
	
	
	
	
	
}
