package br.com.api.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{	
	Optional<Role> findByName(String name);
}
