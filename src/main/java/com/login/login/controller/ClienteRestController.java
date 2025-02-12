package com.login.login.controller;

import com.login.login.model.Cliente;
import com.login.login.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.Optional;

@RestController
public class ClienteRestController {

    //auto instanciamento do repository
    @Autowired
    private ClienteService clienteService;

    //metodo de cadastro ou edição de cliente
    @PostMapping("/api/editarCliente")
    public Cliente cadastrarOuEditarCliente(@Valid @RequestBody Cliente cliente) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String clienteJson = objectMapper.writeValueAsString(cliente);
            System.out.println("Cliente recebido: " + clienteJson);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        if (cliente.getCpf() == null) {
            throw new IllegalArgumentException("CPF não pode ser nulo");
        }
        // Verifica se o cliente existe pelo CPF
        Optional<Cliente> clienteExistente = clienteService.findFirstByCpf(cliente.getCpf());

        if (clienteExistente != null) {

            Cliente resultado = clienteService.saveOrUpdateCliente(cliente);
            return resultado;

        } else {
            // Cliente não existe, crie um novo
            return clienteService.saveOrUpdateCliente(cliente);
        }
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

    //carregar informação do cliente
    @GetMapping("/api/getCliente/{email}")
    public Cliente getCliente(@PathVariable String email) {
        return clienteService.findClienteByEmail(email);
    }
}
