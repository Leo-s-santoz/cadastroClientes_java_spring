package com.login.login.controller;

import com.login.login.model.Cliente;
import com.login.login.service.ClienteService;
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
    private ClienteService clienteService;

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

        clienteService.saveOrUpdateCliente(novoCliente);

        return "gestaoClientes";
    }

    //metodo de exclusao de cliente
    @DeleteMapping("/api/deleteCliente/{email}")
    public String deletarCliente(@PathVariable String email) {
        Cliente cliente = clienteService.findClienteByEmail(email);
        clienteService.deleteCliente(cliente);
        return "gestaoClientes";
    }

    //metodo de listagem de clientes
    @GetMapping("/api/listarClientes")
    public List<Cliente> listarClientes() {
        return (List<Cliente>) clienteService.listarClientes();
    }

    //editar cliente

    //carregar informação do cliente
    @GetMapping("/api/getCliente/{email}")
    public Cliente getCliente(@PathVariable String email) {
        return clienteService.findClienteByEmail(email);
    }

}
