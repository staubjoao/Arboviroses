package br.com.api.repository;

import br.com.api.model.Quarteirao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuarteiraoRepository extends JpaRepository<Quarteirao, Integer> {

    @Query(value =
            "SELECT q.quarteirao_id, q.numero, q.fk_localidade_id\n" +
            "FROM quarteirao q\n" +
            "INNER JOIN (\n" +
            "    SELECT DISTINCT fk_quarteirao_id, fk_usuario_id\n" +
            "    FROM rotas_agentes\n" +
            "    WHERE fk_usuario_id = ?1\n" +
            ") ra ON q.quarteirao_id = ra.fk_quarteirao_id;",
            nativeQuery = true)
    List<Quarteirao> findQuarteiroesByUsuarioId(@Param("usuarioId") Long usuarioId);
}
