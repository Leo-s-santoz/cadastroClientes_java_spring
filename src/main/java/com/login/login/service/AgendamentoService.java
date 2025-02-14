package com.login.login.service;

import com.login.login.model.Agendamento;
import com.login.login.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    public void cancelarAgendamento(Long agendamentoId) {
        agendamentoRepository.cancelarAgendamento(agendamentoId);
    }

    public List<Agendamento> listarAgendamentos(String cpf) {
        return agendamentoRepository.findByClienteCpf(cpf);
    }

    public Agendamento salvarAgendamento(Agendamento agendamento) {
        return agendamentoRepository.save(agendamento);
    }
}
