package br.com.api.repository;

import br.com.api.model.Imovel;
import br.com.api.model.ImovelSequencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImovelSequenciaRepository extends JpaRepository<ImovelSequencia, Integer> {

    List<ImovelSequencia> findByImovel(Imovel imovel);

}
