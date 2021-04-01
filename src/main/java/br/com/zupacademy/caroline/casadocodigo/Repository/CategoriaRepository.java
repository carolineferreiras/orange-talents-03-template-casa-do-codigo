package br.com.zupacademy.caroline.casadocodigo.Repository;

import br.com.zupacademy.caroline.casadocodigo.Models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoriaRepository extends JpaRepository <Categoria, Long> {
}
