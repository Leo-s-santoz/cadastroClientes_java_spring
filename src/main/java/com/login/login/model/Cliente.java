package com.login.login.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Cliente {

    @Id
    private String cpf;

    @NotEmpty
    public String nome;

    @NotEmpty
    public String nascimento;

    @Embedded
    @NotEmpty
    @AttributeOverrides({
            @AttributeOverride(name = "cep", column = @Column(name = "endereco_cep")),
            @AttributeOverride(name = "logradouro", column = @Column(name = "endereco_logradouro")),
            @AttributeOverride(name = "bairro", column = @Column(name = "endereco_bairro")),
            @AttributeOverride(name = "estado", column = @Column(name = "endereco_estado")),
            @AttributeOverride(name = "cidade", column = @Column(name = "endereco_cidade"))
    })
    public Endereco endereco;

    @Embedded
    @NotEmpty
    @AttributeOverrides({
            @AttributeOverride(name = "cep", column = @Column(name = "cobranca_cep")),
            @AttributeOverride(name = "logradouro", column = @Column(name = "cobranca_logradouro")),
            @AttributeOverride(name = "bairro", column = @Column(name = "cobranca_bairro")),
            @AttributeOverride(name = "estado", column = @Column(name = "cobranca_estado")),
            @AttributeOverride(name = "cidade", column = @Column(name = "cobranca_cidade"))
    })
    public Endereco enderecoCobranca;

    @NotEmpty
    public String telefone;

    @NotEmpty
    public String whatsapp;

    @NotEmpty
    @Column(unique = true)
    public String email;

    //getters and setters

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Endereco getEnderecoCobranca() {
        return enderecoCobranca;
    }

    public void setEnderecoCobranca(Endereco enderecoCobranca) {
        this.enderecoCobranca = enderecoCobranca;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

