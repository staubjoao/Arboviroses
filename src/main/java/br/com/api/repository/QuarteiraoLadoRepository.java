package br.com.api.repository;

import br.com.api.model.Quarteirao;
import br.com.api.model.QuarteiraoLado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuarteiraoLadoRepository extends JpaRepository<QuarteiraoLado, Integer> {

    List<QuarteiraoLado> findByQuarteirao(Quarteirao quarteirao);
}
