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
}

