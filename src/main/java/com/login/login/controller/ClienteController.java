package com.login.login.controller;

import com.login.login.model.Cliente;
import java.util.List;
import com.login.login.repository.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

@Controller
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    //servir pagina gestão de clientes
    @GetMapping("/gestaoClientes")
    public String gestaoClientes() {
        return "gestaoClientes";
    }

    //servir pagina de cadastro de cliente
    @GetMapping("/inserirCliente")
    public String inserirCliente() {
        return "inserirCliente";
    }

    //servir pagina edição de cliente
    @GetMapping("/editarCliente")
    public String editarCliente(@RequestParam("cpf") String cpf, Model model) {
        Cliente cliente = clienteRepository.findFirstByCpf(cpf);
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não encontrado: " + cpf);
        }
        model.addAttribute("cliente", cliente);
        return "editarCliente";
    }
}

