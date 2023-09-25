package br.com.api.repository;

import br.com.api.model.BairroModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BairroRepository extends JpaRepository<BairroModel, Integer> {
}
