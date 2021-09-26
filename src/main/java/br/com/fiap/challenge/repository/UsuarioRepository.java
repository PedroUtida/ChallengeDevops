package br.com.fiap.challenge.repository;

import br.com.fiap.challenge.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    List<Usuario> findByNomeContainsIgnoreCase(String nome);


}
