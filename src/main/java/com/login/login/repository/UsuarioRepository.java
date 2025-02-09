package com.login.login.repository;

import com.login.login.model.Usuario;
import org.springframework.data.repository.CrudRepository;


public interface UsuarioRepository extends CrudRepository<Usuario, String> {

    Usuario findById(long id);
}
