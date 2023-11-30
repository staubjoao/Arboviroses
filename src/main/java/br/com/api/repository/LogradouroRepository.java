package br.com.api.repository;


import br.com.api.model.Logradouro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogradouroRepository extends JpaRepository<Logradouro, Integer> {
    @Query("SELECT logradouro FROM Logradouro where logradouro like %:keyword%")
    public List<String> search(@Param("keyword") String keyword);
}
