package br.com.api.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.model.Localidade;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalidadeRepository extends JpaRepository<Localidade, Integer> {
    
}