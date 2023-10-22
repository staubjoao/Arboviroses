package br.com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.api.model.RegistroAntivetorial;

@Repository
public interface RegistroAntivetorialRepository extends JpaRepository<RegistroAntivetorial, Integer> {
    
}
