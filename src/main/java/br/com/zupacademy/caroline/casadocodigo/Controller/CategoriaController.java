package br.com.zupacademy.caroline.casadocodigo.Controller;



import br.com.zupacademy.caroline.casadocodigo.DTO.CategoriaResponseDTO;
import br.com.zupacademy.caroline.casadocodigo.Models.Categoria;
import br.com.zupacademy.caroline.casadocodigo.Repository.CategoriaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    private CategoriaRepository categoriaRepository;

    public CategoriaController(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @PostMapping
    public ResponseEntity<CategoriaResponseDTO> save(@RequestBody Categoria requestDTO ){
        Categoria categoria = requestDTO;
        return ResponseEntity.ok().body(new CategoriaResponseDTO(categoriaRepository.save(categoria)));
    }
}
