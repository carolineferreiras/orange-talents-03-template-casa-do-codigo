package br.com.zupacademy.caroline.casadocodigo.Models;



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
    @Column(unique = true)
    private String titulo;
    @Size(max = 500)
    private String resumo;
    private String sumario;
    @Min(20)
    private BigDecimal preco;
    @Min(100)
    private Integer numPaginas;
    @Column(unique = true)
    private String indetificador;
    @Future
    private LocalDate dataPublicacao;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "idAutor")
    private Autor autor;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "idCategoria")
    private Categoria categoria;

    public Livro() {
    }

    public Livro(Long id, String titulo, @Size(max = 500) String resumo, String sumario,
                 @Min(20) BigDecimal preco, @Min(100) Integer numPaginas,
                 String indetificador, @Future LocalDate dataPublicacao, Autor autor, Categoria categoria) {
        this.id = id;
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numPaginas = numPaginas;
        this.indetificador = indetificador;
        this.dataPublicacao = dataPublicacao;
        this.autor = autor;
        this.categoria = categoria;
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

    public Autor getAutor() {
        return autor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Long getId() {
        return id;
    }
}
