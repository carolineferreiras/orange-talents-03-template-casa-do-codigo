package br.com.zupacademy.caroline.casadocodigo.Controller;


import br.com.zupacademy.caroline.casadocodigo.DTO.EstadoRequestDTO;
import br.com.zupacademy.caroline.casadocodigo.DTO.EstadosResponseDTO;
import br.com.zupacademy.caroline.casadocodigo.Models.Estados;
import br.com.zupacademy.caroline.casadocodigo.Repository.EstadosRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    private EstadosRepository estadosRepository;

    public EstadoController(EstadosRepository estadosRepository) {
        this.estadosRepository = estadosRepository;
    }
    @Transactional
    @PostMapping
    public ResponseEntity<EstadosResponseDTO> save(@RequestBody @Valid EstadoRequestDTO requestDTO ){
    Estados estados = requestDTO.converter();
        return ResponseEntity.ok().body(new EstadosResponseDTO(estadosRepository.save(estados)));
}
}

