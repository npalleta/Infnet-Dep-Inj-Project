package br.com.infnet.project.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.infnet.project.model.domain.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

	public Usuario findByEmail(String email);
	
    /* @Query("DELETE FROM tusuario u WHERE u.email = :email")
       Usuario deleteByEmail(@Param("email") String email); */
}