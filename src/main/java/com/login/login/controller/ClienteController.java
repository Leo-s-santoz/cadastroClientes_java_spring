package com.login.login.controller;

import com.login.login.model.Cliente;
import java.util.List;
import com.login.login.repository.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/gestaoClientes")
    public String gestaoClientes() {
        return "gestaoClientes";
    }

    @GetMapping("/inserirCliente")
    public String cadastroCliente() {
        return "inserirCliente";
    }

    @PostMapping("/inserirCliente")
    public String inserirCliente(@Valid Cliente novoCliente, BindingResult result, Model model) {

        if(result.hasErrors()){
            for (ObjectError error : result.getAllErrors()) {
                System.out.println(error.getDefaultMessage());
            }
            model.addAttribute("errors", result.getAllErrors());
            return "redirect:/inserirCliente";
        }

        clienteRepository.save(novoCliente);

        return null;
    }

    @GetMapping("/api/clientes")
    public List<Cliente> listarClientes() {
        return (List<Cliente>) clienteRepository.findAll();
    }
}

