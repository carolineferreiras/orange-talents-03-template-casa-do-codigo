package br.com.zupacademy.caroline.casadocodigo.DTO;

import br.com.zupacademy.caroline.casadocodigo.Models.Autor;
import br.com.zupacademy.caroline.casadocodigo.Models.Categoria;
import br.com.zupacademy.caroline.casadocodigo.Valid.UniqueValueValid;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorRequestDTO {

    @NotBlank
    @JsonProperty("nome")
    private String nome;
    @Email
    @NotBlank
    @UniqueValueValid(field = "email", classe = Autor.class)
    @JsonProperty ("email")
    private String email;
    @NotBlank @Size(max=400)
    @JsonProperty ("descricao")
    private String descricao;

    public AutorRequestDTO() {
    }

    public AutorRequestDTO(@NotBlank String nome, @Email @NotBlank String email, @NotBlank @Size(max = 400) String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
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

    public Autor converter() { return new Autor(this.nome, this.email, this.descricao);}
}
