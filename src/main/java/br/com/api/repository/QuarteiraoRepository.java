package br.com.api.repository;

import br.com.api.model.Quarteirao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuarteiraoRepository extends JpaRepository<Quarteirao, Integer> {

    @Query(value =
            "SELECT q.quarteirao_id, q.numero, q.fk_localidade_id, ST_AsText(q.poligono) AS poligono " +
                    "FROM " +
                    "quarteirao q " +
                    "INNER JOIN ( " +
                    "    SELECT DISTINCT fk_quarteirao_id, fk_usuario_id\n" +
                    "    FROM rotas_agentes " +
                    "    WHERE fk_usuario_id = :usuarioId " +
                    ") ra ON q.quarteirao_id = ra.fk_quarteirao_id;",
            nativeQuery = true)
    List<Quarteirao> findQuarteiroesByUsuarioId(@Param("usuarioId") Long usuarioId);

    @Query(value = "SELECT q.quarteirao_id, q.numero, q.fk_localidade_id, ST_AsText(q.poligono) AS poligono " +
            "FROM quarteirao q WHERE q.fk_localidade_id = :localidadeId ;", nativeQuery = true)
    List<Quarteirao> findQuarteiroesByLocalidadeId(@Param("localidadeId") Long localidadeId);

    @Query(value = "SELECT ST_AsText(ST_Centroid(ST_Collect(poligono))) FROM quarteirao WHERE fk_localidade_id = :localidadeId ;", nativeQuery = true)
    String findCentroLocalidade(@Param("localidadeId") Long localidadeId);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO quarteirao (numero, fk_localidade_id, poligono) " +
            "VALUES (:numero, :localidadeId, ST_GeomFromText(:poligonoWkt, 4326));", nativeQuery = true)
    void salvarQuarteirao(@Param("numero") Integer numero,
                          @Param("localidadeId") Integer localidadeId,
                          @Param("poligonoWkt") String poligonoWkt);

    @Modifying
    @Transactional
    @Query(value = "UPDATE quarteirao SET numero = :numero, fk_localidade_id = :localidadeId, poligono = ST_GeomFromText(:poligonoWkt, 4326) WHERE (quarteirao_id = :id);", nativeQuery = true)
    void alterarQuarteirao(@Param("id") Integer id,
                           @Param("numero") Integer numero,
                           @Param("localidadeId") Integer localidadeId,
                           @Param("poligonoWkt") String poligonoWkt);

    @Modifying
    @Query(value = "SELECT q.quarteirao_id, q.numero, q.fk_localidade_id, ST_AsText(q.poligono) AS poligono FROM quarteirao q;", nativeQuery = true)
    List<Quarteirao> findAllQuarteiroes();


}
