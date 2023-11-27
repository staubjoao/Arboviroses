package br.com.api.repository;

import br.com.api.model.Imovel;
import br.com.api.model.Quarteirao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ImovelRepository extends JpaRepository<Imovel, Integer> {
    List<Imovel> findByQuarteirao(Quarteirao quarteirao);
}
