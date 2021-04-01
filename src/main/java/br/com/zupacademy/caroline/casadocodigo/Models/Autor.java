package br.com.zupacademy.caroline.casadocodigo.Models;


import com.sun.istack.NotNull;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
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
    @NotNull @NotEmpty
    private String nome;
    @Email
    @NotNull @NotEmpty
    @Column(unique = true)
    private String email;
    @NotNull @NotEmpty @Size(max=400)
    private String descricao;

    private LocalDateTime data_cadastro = LocalDateTime.now();

    public Autor() {
    }

    public Autor(@NotEmpty String nome, @Email @NotEmpty String email, @NotEmpty @Size(max = 400) String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
