package br.com.zupacademy.caroline.casadocodigo.DTO;


import br.com.zupacademy.caroline.casadocodigo.Models.Categoria;
import br.com.zupacademy.caroline.casadocodigo.Valid.UniqueValueValid;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class CategoriaRequestDTO {


    @NotBlank
    @UniqueValueValid(field = "nome",classe = Categoria.class)
    private String nome;

    public CategoriaRequestDTO() {
    }

    @JsonCreator
    public CategoriaRequestDTO(@JsonProperty ("nome")  @NotBlank String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public Categoria converter(){
        return new Categoria(this.nome);
    }

}
