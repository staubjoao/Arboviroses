package br.com.api.repository;

import br.com.api.model.TipoImovelModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoImovelRepository extends JpaRepository<TipoImovelModel, Integer> {
}
