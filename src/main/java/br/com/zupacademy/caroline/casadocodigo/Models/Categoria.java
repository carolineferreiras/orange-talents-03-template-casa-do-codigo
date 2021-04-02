package br.com.zupacademy.caroline.casadocodigo.Models;

import br.com.zupacademy.caroline.casadocodigo.Valid.UniqueValueValid;
import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;


@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"nome"})})
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty @NotNull
    @Column(unique = true)
    private String nome;

    public Categoria() {
    }

    public Categoria(@NotEmpty String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

}
