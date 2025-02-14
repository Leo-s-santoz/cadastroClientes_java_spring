package com.login.login.controller;

import com.login.login.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    @GetMapping("/inserirAgendamento")
    public String inserirAgendamento() {
        return "inserirAgendamento";
    }

    @GetMapping("/agendamentosDoCliente")
    public String agendamentosDoCliente() {
        return "agendamentosDoCliente";
    }
}
