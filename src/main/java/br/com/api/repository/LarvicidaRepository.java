package br.com.api.repository;

import br.com.api.model.larvicida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LarvicidaRepository extends JpaRepository<larvicida, Long> {
}
