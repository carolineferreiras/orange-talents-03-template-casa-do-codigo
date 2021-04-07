package br.com.zupacademy.caroline.casadocodigo.DTO;

import br.com.zupacademy.caroline.casadocodigo.Models.Estados;
import br.com.zupacademy.caroline.casadocodigo.Models.Pais;

import javax.validation.constraints.NotEmpty;


public class EstadoRequestDTO {

    @NotEmpty
    private String nome;
    private Pais id_pais;

    public EstadoRequestDTO() {
    }

    public EstadoRequestDTO(String nome, Pais id_pais) {
        this.nome = nome;
        this.id_pais = id_pais;
    }

    public String getNome() {
        return nome;
    }

    public Pais getId_pais() {
        return id_pais;
    }

    public Estados converter() {
        return new Estados(this.nome,this.id_pais);
    }
}

