package br.com.zupacademy.caroline.casadocodigo.DTO;

import br.com.zupacademy.caroline.casadocodigo.Models.Pais;

public class PaisResponseDTO {


    private Long id;
    private String nome;


    public PaisResponseDTO(Pais entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
