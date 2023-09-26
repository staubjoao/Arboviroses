package br.com.api.repository;

import br.com.api.model.QuarteiraoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuarteiraoRepository extends JpaRepository<QuarteiraoModel, Integer> {
}
