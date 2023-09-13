package br.com.api.repository;

import br.com.api.model.TipoImovel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoImovelRepository extends JpaRepository<TipoImovel, Integer> {
}
