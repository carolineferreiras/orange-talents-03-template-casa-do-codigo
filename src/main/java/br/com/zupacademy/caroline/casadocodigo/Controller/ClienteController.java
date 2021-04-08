package br.com.zupacademy.caroline.casadocodigo.Controller;

import br.com.zupacademy.caroline.casadocodigo.DTO.ClienteRequestDTO;
import br.com.zupacademy.caroline.casadocodigo.DTO.ClienteResponseDTO;
import br.com.zupacademy.caroline.casadocodigo.Models.Cliente;
import br.com.zupacademy.caroline.casadocodigo.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }


    @Transactional
    @PostMapping
    public ResponseEntity<ClienteResponseDTO> save(@Valid @RequestBody ClienteRequestDTO requestDTO ){
        Cliente cliente = requestDTO.converter();
        return ResponseEntity.ok().body(new ClienteResponseDTO(clienteRepository.save(cliente)));
    }

}
