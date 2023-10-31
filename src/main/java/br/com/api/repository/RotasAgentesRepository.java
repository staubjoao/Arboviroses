package br.com.api.repository;

import br.com.api.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.model.RotasAgentes;

import java.util.List;

public interface RotasAgentesRepository extends JpaRepository<RotasAgentes, Integer> {
    List<RotasAgentes> findByUsuario(Usuario usuario);
}
