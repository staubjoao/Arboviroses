package br.com.api.repository;


import br.com.api.model.LogradouroModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogradouroRepository extends JpaRepository<LogradouroModel, Integer> {
}
