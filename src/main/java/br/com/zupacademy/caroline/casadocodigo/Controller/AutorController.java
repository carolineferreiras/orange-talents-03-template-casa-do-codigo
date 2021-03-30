package br.com.zupacademy.caroline.casadocodigo.Controller;

import br.com.zupacademy.caroline.casadocodigo.DTO.AutorRequestDTO;
import br.com.zupacademy.caroline.casadocodigo.DTO.AutorResponseDTO;
import br.com.zupacademy.caroline.casadocodigo.Models.Autor;
import br.com.zupacademy.caroline.casadocodigo.Repository.AutorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/autor")
public class AutorController {

    private AutorRepository autorRepository;

    public AutorController(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @PostMapping
    public ResponseEntity<AutorResponseDTO> save(@RequestBody @Valid AutorRequestDTO requestDTO ){
        Autor autor = requestDTO.converter();
        return ResponseEntity.ok().body(new AutorResponseDTO(autorRepository.save(autor)));
    }
}

