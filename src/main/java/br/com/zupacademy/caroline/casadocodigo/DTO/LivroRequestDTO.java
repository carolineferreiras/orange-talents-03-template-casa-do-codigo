package br.com.zupacademy.caroline.casadocodigo.DTO;

import br.com.zupacademy.caroline.casadocodigo.Models.Autor;
import br.com.zupacademy.caroline.casadocodigo.Models.Categoria;
import br.com.zupacademy.caroline.casadocodigo.Models.Livro;
import br.com.zupacademy.caroline.casadocodigo.Valid.ExistsId;
import br.com.zupacademy.caroline.casadocodigo.Valid.UniqueValueValid;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroRequestDTO {


    @UniqueValueValid(field = "titulo",classe = Livro.class)
    private String titulo;


    @Size(max = 500)
    private String resumo;

    private String sumario;

    @Min(20)
    private BigDecimal preco;


    @Min(100)
    private Integer numPaginas;


    @UniqueValueValid(field = "indetificador",classe = Livro.class)
    private String indetificador;

    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataPublicacao;


    @ExistsId(fieldName = "id", domainClass = Categoria.class)
    private Long id_Categoria;


    @ExistsId(fieldName = "id", domainClass = Autor.class)
    private Long id_Autor;

    public LivroRequestDTO() {
    }

    public LivroRequestDTO(String titulo, @Size(max = 500) String resumo, String sumario,
                           @Min(20) BigDecimal preco, @Min(100) Integer numPaginas,
                           String indetificador, @Future LocalDate dataPublicacao, Long idCategoria, Long idAutor) {
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

    public Long getId_Categoria() {
        return id_Categoria;
    }

    public Long getId_Autor() {
        return id_Autor;
    }

    public Livro converter(EntityManager manager) {
        @NotNull Autor autor = manager.find(Autor.class, id_Autor);
        @NotNull Categoria categoria = manager.find(Categoria.class, id_Categoria);

        Assert.state(autor!=null,"Você esta querendo cadastrar um livro para um autor que nao existe no banco "+id_Autor);
        Assert.state(categoria!=null,"Você esta querendo cadastrar um livro para uma categoria que nao existe no banco "+id_Categoria);

        return new Livro(titulo,resumo,sumario,preco,
                       numPaginas,indetificador,dataPublicacao, autor, categoria);
    }

}






