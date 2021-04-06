package br.com.zupacademy.caroline.casadocodigo.Controller;


import br.com.zupacademy.caroline.casadocodigo.DTO.LivroRequestDTO;
import br.com.zupacademy.caroline.casadocodigo.DTO.LivroResponseDTO;
import br.com.zupacademy.caroline.casadocodigo.Models.Autor;
import br.com.zupacademy.caroline.casadocodigo.Models.Categoria;
import br.com.zupacademy.caroline.casadocodigo.Models.Livro;
import br.com.zupacademy.caroline.casadocodigo.Repository.AutorRepository;
import br.com.zupacademy.caroline.casadocodigo.Repository.CategoriaRepository;
import br.com.zupacademy.caroline.casadocodigo.Repository.LivroRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/livros")
public class LivroController {

    private LivroRepository livroRepository;
    private CategoriaRepository categoriaRepository;
    private AutorRepository  autorRepository;

    @PersistenceContext
    private EntityManager manager;


    public LivroController(LivroRepository livroRepository, CategoriaRepository categoriaRepository, AutorRepository autorRepository) {
        this.livroRepository = livroRepository;
        this.categoriaRepository = categoriaRepository;
        this.autorRepository = autorRepository;
    }

    @Transactional
    @PostMapping
    public ResponseEntity<LivroResponseDTO> save(@Valid @RequestBody LivroRequestDTO requestDTO ){

        Autor autor = autorRepository.findById(requestDTO.getId_Autor()).get();
        Categoria categoria = categoriaRepository.findById(requestDTO.getId_Categoria()).get();

        Livro livro = requestDTO.converter(manager);

        return ResponseEntity.ok().body(new LivroResponseDTO(livroRepository.save(livro)));
    }

    @GetMapping
    public ResponseEntity<List<LivroResponseDTO>> listaLivros() {

        List<Livro> livroList = livroRepository.findAll();

        return ResponseEntity.ok(
                livroList.stream().map(LivroResponseDTO::new).collect(Collectors.toList()));
    }

}
