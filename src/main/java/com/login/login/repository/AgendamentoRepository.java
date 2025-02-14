package com.login.login.repository;

import com.login.login.model.Agendamento;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface  AgendamentoRepository extends CrudRepository <Agendamento, String> {

    @Modifying
    @Transactional
    @Query("UPDATE Agendamento a SET a.status = 'CANCELADO' WHERE a.id = :id")
    void cancelarAgendamento(Long id);

    @Query("SELECT a FROM Agendamento a WHERE a.cliente.cpf = :cpf")
    List<Agendamento> findByClienteCpf(String cpf);
}
