package br.com.zupacademy.caroline.casadocodigo.Form;

import br.com.zupacademy.caroline.casadocodigo.Models.Autor;
import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class AutorForm {

    @NotNull
    @NotEmpty
    private String nome;
    @Email
    @NotNull @NotEmpty
    @Column(unique = true)
    private String email;
    @NotNull @NotEmpty @Size(max=400)
    private String descricao;


    public Autor converter(){
      return new Autor(nome,email,descricao);
    }

}
