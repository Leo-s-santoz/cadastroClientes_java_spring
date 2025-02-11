package com.login.login.controller;

import com.login.login.model.Cliente;
import com.login.login.repository.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteRestController {

    //auto instanciamento do repository
    @Autowired
    private ClienteRepository clienteRepository;

    //metodo de cadastro de cliente
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

        return "gestaoClientes";
    }

    //metodo de exclusao de cliente
    @DeleteMapping("/api/deleteCliente/{email}")
    public String deletarCliente(@PathVariable String email) {
        Cliente cliente = clienteRepository.findFirstByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado: " + email));
        clienteRepository.delete(cliente);
        return "gestaoClientes";
    }

    //metodo de listagem de clientes
    @GetMapping("/api/listarClientes")
    public List<Cliente> listarClientes() {
        return (List<Cliente>) clienteRepository.findAll();
    }

}
