package br.com.zupacademy.caroline.casadocodigo.Repository;


import br.com.zupacademy.caroline.casadocodigo.Models.Estados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadosRepository extends JpaRepository<Estados, Long> {

}
