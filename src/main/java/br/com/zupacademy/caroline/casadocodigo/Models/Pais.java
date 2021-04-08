package br.com.zupacademy.caroline.casadocodigo.Models;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Pais implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @NotNull
    @Column(unique = true)
    private String nome;

    public Pais() {
    }

    public Pais(@NotEmpty String nome) {
        this.nome = nome;
    }

    public Pais(String titulo, String resumo, String sumario, BigDecimal preco, Integer numPaginas, String indetificador, LocalDate dataPublicacao, Long id_categoria, Long id_autor) {
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}