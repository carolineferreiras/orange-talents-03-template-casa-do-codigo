package br.com.zupacademy.caroline.casadocodigo.Controller;


import br.com.zupacademy.caroline.casadocodigo.DTO.LIvroRequestDTO;
import br.com.zupacademy.caroline.casadocodigo.DTO.LivroResponseDTO;
import br.com.zupacademy.caroline.casadocodigo.Models.Livro;
import br.com.zupacademy.caroline.casadocodigo.Repository.LivroRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/livros")
public class LivroController {

    private LivroRepository livroRepository;

    public LivroController(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @PostMapping
    public ResponseEntity<LivroResponseDTO> save(@RequestBody @Valid LIvroRequestDTO requestDTO){
        Livro livro = requestDTO.converter();
        return ResponseEntity.ok().body(new LivroResponseDTO(livroRepository.save(livro)));
    }

}
