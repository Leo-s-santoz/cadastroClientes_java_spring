package com.login.login.repository;

import org.springframework.data.repository.CrudRepository;
import com.login.login.model.Cliente;

import java.util.List;
import java.util.Optional;

//Metodos CRUD foram herdados de CrudRepository aplicados a classe Cliente
public interface ClienteRepository extends CrudRepository<Cliente, String> {

    Optional<Cliente> findFirstByEmail(String email);

    Optional<Cliente> findFirstByCpf(String cpf);
}
