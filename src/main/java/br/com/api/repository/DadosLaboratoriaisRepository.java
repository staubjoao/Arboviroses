package br.com.api.repository;

import br.com.api.model.DadosLaboratoriais;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DadosLaboratoriaisRepository extends JpaRepository<DadosLaboratoriais, Integer> {
}
