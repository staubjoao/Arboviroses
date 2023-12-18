package br.com.api.repository;

import br.com.api.model.Larvicida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LarvicidaRepository extends JpaRepository<Larvicida, Long> {
}
