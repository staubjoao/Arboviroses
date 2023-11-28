package br.com.api.repository;

import br.com.api.model.Quarteirao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuarteiraoRepository extends JpaRepository<Quarteirao, Integer> {

    @Query("SELECT q FROM Quarteirao q JOIN q.rotasAgentes ra WHERE ra.usuario.id = :usuarioId")
    List<Quarteirao> findQuarteiroesByUsuarioId(@Param("usuarioId") Long usuarioId);
}
