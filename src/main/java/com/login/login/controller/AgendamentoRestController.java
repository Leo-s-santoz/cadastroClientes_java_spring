package com.login.login.controller;

import com.login.login.model.Agendamento;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.login.login.service.AgendamentoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

@RestController
public class AgendamentoRestController {

    private static final Logger logger = LoggerFactory.getLogger(AgendamentoRestController.class);

    @Autowired
    private AgendamentoService agendamentoService;

    @PostMapping("/api/inserirAgendamento")
    public String adicionarAgendamento(@Valid @RequestBody Agendamento agendamento){

        Agendamento resultado = agendamentoService.salvarAgendamento(agendamento);
        return resultado.toString();
    }

    @RequestMapping("/api/agendamentos/{cpf}")
    public List<Agendamento> listarAgendamentosPorCpf(@PathVariable String cpf) {

        List<Agendamento> agendamentos = agendamentoService.listarAgendamentos(cpf);
        logger.info("Agendamentos encontrados: {}", agendamentos);
        return agendamentos;
    }
}
