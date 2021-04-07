package br.com.zupacademy.caroline.casadocodigo.Controller;


import br.com.zupacademy.caroline.casadocodigo.DTO.*;
import br.com.zupacademy.caroline.casadocodigo.Models.Autor;
import br.com.zupacademy.caroline.casadocodigo.Models.Categoria;
import br.com.zupacademy.caroline.casadocodigo.Models.Livro;
import br.com.zupacademy.caroline.casadocodigo.Repository.AutorRepository;
import br.com.zupacademy.caroline.casadocodigo.Repository.CategoriaRepository;
import br.com.zupacademy.caroline.casadocodigo.Repository.LivroRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/livros")
public class LivroController {

    private LivroRepository livroRepository;
    private CategoriaRepository categoriaRepository;
    private AutorRepository  autorRepository;



    public LivroController(LivroRepository livroRepository, CategoriaRepository categoriaRepository, AutorRepository autorRepository) {
        this.livroRepository = livroRepository;
        this.categoriaRepository = categoriaRepository;
        this.autorRepository = autorRepository;
    }

    @Transactional
    @PostMapping
    public ResponseEntity<LivroResponseDTO> save(@Valid @RequestBody LivroRequestDTO requestDTO , CategoriaRequestDTO categoriaRequestDTO, AutorRequestDTO autorRequestDTO){

        Autor autor = autorRepository.findById(categoriaRequestDTO.converter().getId()).get();
        Categoria categoria = categoriaRepository.findById(autorRequestDTO.converter().getId()).get();

        Livro livro = requestDTO.converter(requestDTO);

        return ResponseEntity.ok().body(new LivroResponseDTO(livroRepository.save(livro)));
    }



    @GetMapping
    public ResponseEntity<List<LivroResponseDTO>> listaLivros() {

        List<Livro> livroList = livroRepository.findAll();

        return ResponseEntity.ok(
                livroList.stream().map(LivroResponseDTO::new).collect(Collectors.toList()));
    }



    @GetMapping("/{id}")
    public ResponseEntity<?> detalhaBusca(@PathVariable Long id) {

        Optional<Livro> livro = livroRepository.findById(id);

        if(livro.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não existe");
        }

        return ResponseEntity.ok(new DetalharLivroResponseDTO(livro.get()));
    }
}
