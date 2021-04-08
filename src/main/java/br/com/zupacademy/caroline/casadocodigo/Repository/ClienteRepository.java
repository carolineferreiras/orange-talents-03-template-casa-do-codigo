package br.com.zupacademy.caroline.casadocodigo.Repository;


import br.com.zupacademy.caroline.casadocodigo.Models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
