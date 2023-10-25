package br.com.api.repository;

import br.com.api.model.Geolocalizacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeolocalizacaoRepository extends JpaRepository<Geolocalizacao, Integer> {
}
