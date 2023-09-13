package br.com.api.repository;

import br.com.api.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

}
