package br.com.zupacademy.caroline.casadocodigo.Models;



import org.apache.juli.logging.Log;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;



@Entity
public class Livro implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(unique = true)
    private String titulo;
    @NotBlank
    @Size(max = 500)
    private String resumo;
    private String sumario;
    @NotNull
    @Min(20)
    private BigDecimal preco;
    @Min(100)
    private Integer numPaginas;
    @NotBlank
    @Column(unique = true)
    private String indetificador;
    @Future
    @NotNull
    private LocalDate dataPublicacao;
    @NotNull
    @ManyToOne
    private Categoria categoria;
    @NotNull
    @ManyToOne
    private Autor autor;


    public Livro() {
    }

    public Livro(String titulo, String resumo, String sumario, BigDecimal preco, Integer numPaginas, String indetificador, LocalDate dataPublicacao, Long idCategoria, Long idAutor) {
        this.id = id;
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numPaginas = numPaginas;
        this.indetificador = indetificador;
        this.dataPublicacao = dataPublicacao;
        this.categoria = categoria;
        this.autor = autor;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
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

    public Categoria getCategoria() {
        return categoria;
    }

    public Autor getAutor() {
        return autor;
    }
}
