package br.com.zupacademy.caroline.casadocodigo.Models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"email"})})
public class Autor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    @Email
    @NotBlank
    @Column(unique = true)
    private String email;
    @NotBlank @Size(max=400)
    private String descricao;

    private LocalDateTime data_cadastro = LocalDateTime.now();

    public Autor() {
    }


    public Autor(String nome, String email, String descricao) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
        this.data_cadastro = data_cadastro;
    }


    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getData_cadastro() {
        return data_cadastro;
    }
}
