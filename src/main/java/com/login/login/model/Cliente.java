package com.login.login.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Cliente {

    @Id
    private String cpf;

    @NotEmpty
    private String nome;

    @NotEmpty
    private String nascimento;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "cep", column = @Column(name = "endereco_cep")),
            @AttributeOverride(name = "logradouro", column = @Column(name = "endereco_logradouro")),
            @AttributeOverride(name = "numero", column = @Column(name = "endereco_numero")),
            @AttributeOverride(name = "bairro", column = @Column(name = "endereco_bairro")),
            @AttributeOverride(name = "estado", column = @Column(name = "endereco_estado")),
            @AttributeOverride(name = "cidade", column = @Column(name = "endereco_cidade"))
    })
    private Endereco endereco;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "cep", column = @Column(name = "cobranca_cep")),
            @AttributeOverride(name = "logradouro", column = @Column(name = "cobranca_logradouro")),
            @AttributeOverride(name = "numero", column = @Column(name = "cobranca_numero")),
            @AttributeOverride(name = "bairro", column = @Column(name = "cobranca_bairro")),
            @AttributeOverride(name = "estado", column = @Column(name = "cobranca_estado")),
            @AttributeOverride(name = "cidade", column = @Column(name = "cobranca_cidade"))
    })
    private Endereco enderecoCobranca;

    @NotEmpty
    private String telefone;

    @NotEmpty
    private String whatsapp;

    @NotEmpty
    @Column(unique = true)
    private String email;

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

