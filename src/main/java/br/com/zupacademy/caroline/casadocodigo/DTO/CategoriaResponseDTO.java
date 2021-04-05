package br.com.zupacademy.caroline.casadocodigo.DTO;


import br.com.zupacademy.caroline.casadocodigo.Models.Categoria;

public class CategoriaResponseDTO {

    private Long id;
    private String nome;

    public CategoriaResponseDTO(Categoria entity) {
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
