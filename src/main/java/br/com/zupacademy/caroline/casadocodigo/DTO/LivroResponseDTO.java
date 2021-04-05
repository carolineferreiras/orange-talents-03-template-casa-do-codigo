package br.com.zupacademy.caroline.casadocodigo.DTO;

import br.com.zupacademy.caroline.casadocodigo.Models.Autor;
import br.com.zupacademy.caroline.casadocodigo.Models.Categoria;
import br.com.zupacademy.caroline.casadocodigo.Models.Livro;

import java.time.LocalDate;

public class LivroResponseDTO {

    private String titulo;
    private String indetificador;
    private LocalDate dataPublicacao;
    private Categoria categoria;
    private Autor autor;

    public LivroResponseDTO(Livro entity) {
        this.titulo = entity.getTitulo();
        this.indetificador = entity.getIndetificador();
        this.dataPublicacao = entity.getDataPublicacao();
        this.categoria = entity.getCategoria();
        this.autor = entity.getAutor();
    }

    public String getTitulo() {
        return titulo;
    }

    public String getIndetificador() {
        return indetificador;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Autor getAutor() {
        return autor;
    }
}
