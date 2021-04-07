package br.com.zupacademy.caroline.casadocodigo.DTO;

import br.com.zupacademy.caroline.casadocodigo.Models.Pais;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import br.com.zupacademy.caroline.casadocodigo.Valid.UniqueValueValid;

import javax.validation.constraints.NotBlank;

public class PaisRequestDTO {

    @NotBlank
    @UniqueValueValid(field = "nome",classe = Pais.class)
    private String nome;

    public PaisRequestDTO() {
    }

    @JsonCreator
    public PaisRequestDTO(@JsonProperty("nome")  @NotBlank String nome) {
        this.nome = nome;
    }

    public Pais converter() {return new Pais(this.nome);}

    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome;}
}
