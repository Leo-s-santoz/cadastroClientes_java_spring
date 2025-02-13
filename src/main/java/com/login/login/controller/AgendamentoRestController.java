package com.login.login.controller;

import com.login.login.model.Agendamento;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.login.login.service.AgendamentoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

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
}
