package br.com.zupacademy.caroline.casadocodigo.DTO;

import br.com.zupacademy.caroline.casadocodigo.Models.Categoria;
import br.com.zupacademy.caroline.casadocodigo.Models.Estados;

public class EstadosResponseDTO {

    private Long id;
    private String nome;

    public EstadosResponseDTO(Estados entity) {
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

