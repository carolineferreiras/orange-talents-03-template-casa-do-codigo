package br.com.zupacademy.caroline.casadocodigo.Repository;


import br.com.zupacademy.caroline.casadocodigo.Models.Autor;
import br.com.zupacademy.caroline.casadocodigo.Models.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {






}
