package br.com.zupacademy.caroline.casadocodigo.DTO;

import br.com.zupacademy.caroline.casadocodigo.Models.Autor;
import br.com.zupacademy.caroline.casadocodigo.Models.Categoria;
import br.com.zupacademy.caroline.casadocodigo.Models.Livro;

import java.time.LocalDate;

public class LivroResponseDTO {

    private Long id;
    private String titulo;

    public LivroResponseDTO(Livro entity) {
        this.id = entity.getId();
        this.titulo = entity.getTitulo();

    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }
}
