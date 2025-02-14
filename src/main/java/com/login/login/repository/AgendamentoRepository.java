package com.login.login.repository;

import com.login.login.model.Agendamento;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface  AgendamentoRepository extends CrudRepository <Agendamento, String> {

    @Query("SELECT a FROM Agendamento a WHERE a.cliente.cpf = :cpf")
    List<Agendamento> findByClienteCpf(String cpf);
}
