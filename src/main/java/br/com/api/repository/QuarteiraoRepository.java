package br.com.api.repository;

import br.com.api.model.Quarteirao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import javax.transaction.Transactional;

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

    @Modifying
    @Query(value = "INSERT INTO quarteirao (quarteirao_id, numero, fk_localidade_id, poligono) " +
            "VALUES (:quarteiraoId, :numero, :localidadeId, ST_GeomFromText(:poligonoWkt, 4326))", nativeQuery = true)
    @Transactional
    void salvarQuarteirao(@Param("quarteiraoId") Integer quarteiraoId,
                          @Param("numero") Integer numero,
                          @Param("localidadeId") Integer localidadeId,
                          @Param("poligonoWkt") String poligonoWkt);

    @Query(value = "SELECT quarteirao_id, numero, fk_localidade_id, ST_AsText(poligono) AS poligono FROM quarteirao;", nativeQuery = true)
    List<Quarteirao> findAllQuarteiroes();




}
