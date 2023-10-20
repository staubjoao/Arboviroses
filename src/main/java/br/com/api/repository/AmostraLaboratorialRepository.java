package br.com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.api.model.AmostraLaboratorial;

@Repository
public interface AmostraLaboratorialRepository extends JpaRepository<AmostraLaboratorial, Integer> {
    
}
