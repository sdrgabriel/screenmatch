package br.com.sdrgabriel.infrastructure.repository;

import br.com.sdrgabriel.infrastructure.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

    UserDetails findByNome(String nome);

}
