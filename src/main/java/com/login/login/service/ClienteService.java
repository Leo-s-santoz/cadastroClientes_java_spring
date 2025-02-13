package com.login.login.service;

import com.login.login.model.Cliente;
import com.login.login.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente saveOrUpdateCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public void deleteCliente(Cliente cliente) {
        clienteRepository.delete(cliente);
    }

    public Iterable<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Cliente findFirstByCpf(String cpf) {
        return clienteRepository.findFirstByCpf(cpf);
    }

    public Cliente findClienteByEmail(String email) {
        return clienteRepository.findFirstByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado: " + email));
    }
}