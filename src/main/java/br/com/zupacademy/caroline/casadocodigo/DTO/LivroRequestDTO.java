package br.com.zupacademy.caroline.casadocodigo.DTO;

import br.com.zupacademy.caroline.casadocodigo.Models.Autor;
import br.com.zupacademy.caroline.casadocodigo.Models.Categoria;
import br.com.zupacademy.caroline.casadocodigo.Models.Livro;
import br.com.zupacademy.caroline.casadocodigo.Valid.ExistsId;
import br.com.zupacademy.caroline.casadocodigo.Valid.UniqueValueValid;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroRequestDTO extends Livro {

    @JsonProperty("titulo")
    @UniqueValueValid(field = "titulo",classe = Livro.class)
    private String titulo;

    @JsonProperty("resumo")
    @Size(max = 500)
    private String resumo;

    @JsonProperty("sumario")
    private String sumario;

    @JsonProperty("preco")
    @Min(20)
    private BigDecimal preco;

    @JsonProperty("num_paginas")
    @Min(100)
    private Integer numPaginas;

    @JsonProperty("indetificador")
    @UniqueValueValid(field = "indetificador",classe = Livro.class)
    private String indetificador;

    @JsonProperty("data_publicacao")
    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataPublicacao;


    @JsonProperty("id_Categoria")
    @ExistsId(fieldName = "id", domainClass = Categoria.class)
    private Long id_Categoria;

    @JsonProperty("id_Autor")
    @ExistsId(fieldName = "id", domainClass = Autor.class)
    private Long id_Autor;

    @Deprecated
    public LivroRequestDTO() {
    }


    @Deprecated
    @JsonCreator
    public LivroRequestDTO(String titulo, @Size(max = 500) String resumo, String sumario, @Min(20) BigDecimal preco,
                           @Min(100) Integer numPaginas, String indetificador,
                           @Future LocalDate dataPublicacao, Long id_Categoria, Long id_Autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numPaginas = numPaginas;
        this.indetificador = indetificador;
        this.dataPublicacao = dataPublicacao;
        this.id_Categoria = id_Categoria;
        this.id_Autor = id_Autor;
    }


    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    @Override
    public String getTitulo() {
        return titulo;
    }

    @Override
    public String getResumo() {
        return resumo;
    }

    @Override
    public String getSumario() {
        return sumario;
    }

    @Override
    public BigDecimal getPreco() {
        return preco;
    }

    @Override
    public Integer getNumPaginas() {
        return numPaginas;
    }

    @Override
    public String getIndetificador() {
        return indetificador;
    }

    @Override
    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public Long getId_Categoria() {
        return id_Categoria;
    }

    public Long getId_Autor() {
        return id_Autor;
    }

    public LivroRequestDTO converter(LivroRequestDTO requestDTO) {
        return new LivroRequestDTO (titulo,resumo,sumario,preco,numPaginas,indetificador,dataPublicacao,id_Categoria,id_Autor);
    }



}






