package br.com.zupacademy.caroline.casadocodigo.DTO;


import br.com.zupacademy.caroline.casadocodigo.Models.Categoria;
import br.com.zupacademy.caroline.casadocodigo.Models.Livro;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DetalharLivroResponseDTO {

    
    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private Integer numPaginas;
    private String indetificador;
    private LocalDate dataPublicacao;
    private Categoria id_Categoria;
    private Long id_Autor;


    public DetalharLivroResponseDTO(Livro entity ,br.com.zupacademy.caroline.casadocodigo.Models.Autor autor, Categoria categoria) {
        this.titulo = entity.getTitulo();
        this.resumo = entity.getResumo();
        this.sumario = entity.getSumario();
        this.preco = entity.getPreco();
        this.numPaginas = entity.getNumPaginas();
        this.indetificador = entity.getIndetificador();
        this.dataPublicacao = entity.getDataPublicacao();
        this.id_Categoria = entity.getCategoria();
        this.id_Autor = entity.getAutor();
    }

    public DetalharLivroResponseDTO(Livro entity) {
    }


    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getNumPaginas() {
        return numPaginas;
    }

    public String getIndetificador() {
        return indetificador;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public Categoria getId_Categoria() {
        return id_Categoria;
    }

    public Long getId_Autor() {
        return id_Autor;
    }
}
