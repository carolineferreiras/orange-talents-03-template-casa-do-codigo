package br.com.zupacademy.caroline.casadocodigo.DTO;

import br.com.zupacademy.caroline.casadocodigo.Models.Autor;
import br.com.zupacademy.caroline.casadocodigo.Models.Categoria;
import br.com.zupacademy.caroline.casadocodigo.Models.Livro;
import br.com.zupacademy.caroline.casadocodigo.Valid.ExistId;
import br.com.zupacademy.caroline.casadocodigo.Valid.UniqueValueValid;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LIvroRequestDTO {

    @NotBlank
    @UniqueValueValid(field = "titulo",classe = Livro.class)
    private String titulo;
    @NotBlank
    @Size(max = 500)
    private String resumo;
    private String sumario;
    @NotNull
    @Min(value = 20)
    private BigDecimal preco;
    @NotNull
    @Min(value = 100)
    private Integer numPaginas;
    @NotBlank
    @UniqueValueValid(field = "indetificador",classe = Livro.class)
    private String indetificador;
    @NotNull
    @Future
    @JsonFormat(pattern = "dd/mm/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataPublicacao;
    @NotNull
    @ExistId(domainClass = Categoria.class)
    private Long idCategoria;
    @NotNull
    @ExistId(domainClass = Autor.class)
    private Long idAutor;

    public LIvroRequestDTO() {
    }


    public Livro converter() {
        return new Livro(this.titulo,this.resumo,this.sumario,this.preco,this.numPaginas,this.indetificador,this.dataPublicacao,this.idCategoria,this.idAutor);
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

    public Long getIdCategoria() {
        return idCategoria;
    }

    public Long getIdAutor() {
        return idAutor;
    }
}
