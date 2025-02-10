package com.login.login.repository;

import org.springframework.data.jpa.repository.Query;
import com.login.login.model.Usuario;
import org.springframework.data.repository.CrudRepository;


public interface UsuarioRepository extends CrudRepository<Usuario, String> {
    //Metodos CRUD foram herdados de CrudRepository aplicados a classe Usuario
    Usuario findById(long id);

    @Query(value = "SELECT * FROM cadastro.usuario WHERE email = :email and senha = :senha", nativeQuery = true)
    Usuario login(String email, String senha);
}
