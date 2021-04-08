package br.com.zupacademy.caroline.casadocodigo.DTO;

import br.com.zupacademy.caroline.casadocodigo.Models.Cliente;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import br.com.zupacademy.caroline.casadocodigo.Valid.UniqueValueValid;

public class ClienteRequestDTO {

    @Email
    @UniqueValueValid(field = "email",classe = Cliente.class)
    private String email;
    @NotEmpty
    private String nome;
    @NotEmpty
    private String sobrenome;
    @NotEmpty
    private String documento;
    @NotEmpty
    private String endereco;
    @NotEmpty
    private String complemento;
    @NotEmpty
    private String cidade;
    @NotEmpty
    private String pais;
    private String estado;
    @NotEmpty
    private String telefone;
    @NotEmpty
    private String cep;

    public ClienteRequestDTO() {
    }

    public ClienteRequestDTO(String email, String nome, String sobrenome, String documento,
                             String endereco, String complemento, String cidade, String pais, String estado, String telefone, String cep) {
        this.email = email;
        this.nome = nome;
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

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
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

    public Cliente converter() {
        return new Cliente(this.nome,this.email,this.sobrenome,this.documento,this.endereco,this.complemento,this.cidade,this.pais,this.estado,this.telefone,this.cep);
    }
}