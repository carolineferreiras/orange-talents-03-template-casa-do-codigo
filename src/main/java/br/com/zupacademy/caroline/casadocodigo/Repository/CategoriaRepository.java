package br.com.zupacademy.caroline.casadocodigo.Repository;


import br.com.zupacademy.caroline.casadocodigo.Models.Categoria;
import br.com.zupacademy.caroline.casadocodigo.Models.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository <Categoria, Long> {

    Optional<Livro> findById(Class<Categoria> categoriaClass);
}
