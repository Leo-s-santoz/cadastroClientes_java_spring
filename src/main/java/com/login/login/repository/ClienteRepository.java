package com.login.login.repository;

import org.springframework.data.repository.CrudRepository;
import com.login.login.model.Cliente;

//Metodos CRUD foram herdados de CrudRepository aplicados a classe Cliente
public interface ClienteRepository extends CrudRepository<Cliente, String> {

    Cliente findFirstByCpf(String cpf);
}
