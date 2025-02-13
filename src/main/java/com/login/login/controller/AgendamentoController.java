package com.login.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AgendamentoController {

    @GetMapping("/inserirAgendamento")
    public String criarAgendamentos() {
        return "inserirAgendamento";
    }
}
