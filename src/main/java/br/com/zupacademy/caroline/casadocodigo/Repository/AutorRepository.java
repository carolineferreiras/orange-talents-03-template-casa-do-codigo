package br.com.zupacademy.caroline.casadocodigo.Repository;

import br.com.zupacademy.caroline.casadocodigo.Models.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository <Autor, Long> {
}
