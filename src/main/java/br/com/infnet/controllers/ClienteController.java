package br.com.infnet.controllers;

import br.com.infnet.dtos.ClientePostDTO;
import br.com.infnet.dtos.ClientePutDTO;
import br.com.infnet.dtos.ClienteResponseDTO;
import br.com.infnet.entities.Cliente;
import br.com.infnet.repositories.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/clientes")
public class ClienteController {

@PostMapping
public ResponseEntity<ClienteResponseDTO> post
        (@RequestBody @Valid ClientePostDTO dto) {
    ClienteResponseDTO response = new ClienteResponseDTO();
    try {
        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());
        cliente.setCpf(dto.getCpf());

        cliente.setEmail(dto.getEmail());

        ClienteRepository clienteRepository
                = new ClienteRepository();
        clienteRepository.create(cliente);

        response.setStatus(201); // CREATED!
        response.setMensagem
                ("Cliente cadastrado com sucesso!");
    } catch (Exception e) {
        response.setStatus(500); // INTERNAL SERVER ERROR!
        response.setMensagem(e.getMessage());
    }

    return ResponseEntity.status
            (response.getStatus()).body(response);
}

@PutMapping
public ResponseEntity<ClienteResponseDTO> put
        (@RequestBody @Valid ClientePutDTO dto) {

    ClienteResponseDTO response = new ClienteResponseDTO();

    try {

        ClienteRepository clienteRepository
                = new ClienteRepository();
        Cliente cliente = clienteRepository
                .findById(dto.getIdCliente());

        if (cliente != null) {

            cliente.setNome(dto.getNome());
            cliente.setEmail(dto.getEmail());
            cliente.setCpf(dto.getCpf());

            clienteRepository.update(cliente);

            response.setStatus(200); // OK!
            response.setMensagem
                    ("Cliente atualizado com sucesso.");
        } else {

            response.setStatus(404); // NOT FOUND
            response.setMensagem
                    ("Cliente não encontrado. Verifique o ID informado.");
        }
    } catch (Exception e) {
        response.setStatus(500); // INTERNAL SERVER ERROR!
        response.setMensagem(e.getMessage());
    }

    return ResponseEntity.status
            (response.getStatus()).body(response);
}


@DeleteMapping("{idCliente}")
public ResponseEntity <ClienteResponseDTO> delete(@PathVariable("idCliente") Integer idCliente){

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
            response.setMensagem("Cliente não encontrado.Verifique o ID informado.");

        }
    }catch(Exception e){
        response.setStatus(500);
        response.setMensagem(e.getMessage());
    }
    return ResponseEntity.status(response.getStatus()).body(response);
}

@GetMapping
public List<Cliente> getAll(){
    try{

        ClienteRepository clienteRepository = new ClienteRepository();
        return clienteRepository.findAll();

    }catch(Exception e){
        e.printStackTrace();
        return null;

    }



}

@GetMapping("{idCliente}")
public Cliente getById(@PathVariable("idCliente") Integer idCliente){

    try{

        ClienteRepository clienteRepository = new ClienteRepository();
        return clienteRepository.findById(idCliente);

    }catch(Exception e){

        e.printStackTrace();

        return null;

    }


}
}
