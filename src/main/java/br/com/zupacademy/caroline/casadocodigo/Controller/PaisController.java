package br.com.zupacademy.caroline.casadocodigo.Controller;



import br.com.zupacademy.caroline.casadocodigo.DTO.PaisRequestDTO;
import br.com.zupacademy.caroline.casadocodigo.DTO.PaisResponseDTO;
import br.com.zupacademy.caroline.casadocodigo.Models.Pais;
import br.com.zupacademy.caroline.casadocodigo.Repository.PaisRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/pais")
public class PaisController {

    private PaisRepository paisRepository;

    public PaisController(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    @Transactional
    @PostMapping
    public ResponseEntity<PaisResponseDTO> save(@Valid @RequestBody PaisRequestDTO requestDTO ){
        Pais pais = requestDTO.converter();
        return ResponseEntity.ok().body(new PaisResponseDTO(paisRepository.save(pais)));
    }

}
