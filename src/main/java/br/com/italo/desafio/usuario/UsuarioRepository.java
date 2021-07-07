package br.com.italo.desafio.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Boolean existsByCpf(String cpf);
    Boolean existsByEmail(String email);
}

