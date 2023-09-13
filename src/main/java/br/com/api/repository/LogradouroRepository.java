package br.com.api.repository;


import br.com.api.model.Logradouro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogradouroRepository extends JpaRepository<Logradouro, Integer> {
}
