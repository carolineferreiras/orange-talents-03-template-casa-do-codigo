package br.com.zupacademy.caroline.casadocodigo.Models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String nome;
    @Email
    @NotNull
    @Column(unique = true)
    private String email;
    @NotNull
    private String sobrenome;
    @Column(unique = true)
    @NotNull
    private String documento;
    @NotNull
    private String endereco;
    @NotNull
    private String complemento;
    @NotNull
    private String cidade;
    @NotNull
    private String pais;
    private String estado;
    @NotNull
    private String telefone;
    @NotNull
    private String cep;

    public Cliente(Long id, String nome, String email, String sobrenome, String documento,
                   String endereco, String complemento, String cidade, String pais, String estado, String telefone, String cep) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
        this.estado = estado;
        this.telefone = telefone;
        this.cep = cep;
    }

    public Cliente(String nome, String email, String sobrenome, String documento, String endereco,
                   String complemento, String cidade, String pais, String estado, String telefone, String cep) {
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

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public String getPais() {
        return pais;
    }

    public String getEstado() {
        return estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }
}
