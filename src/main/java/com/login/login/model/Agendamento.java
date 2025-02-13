package com.login.login.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.Date;

@Entity
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cpf", referencedColumnName = "cpf")
    private Cliente cliente;

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

    @NotEmpty
    private String telefone;

    @NotEmpty
    private String whatsapp;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;

    @NotEmpty
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAdendada;

    @PrePersist
    protected void onCreate() {
        dataCriacao = new Date();
    }


    //getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
        this.endereco = cliente.getEndereco();
        this.telefone = cliente.getTelefone();
        this.whatsapp = cliente.getWhatsapp();
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
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

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataAdendada() {
        return dataAdendada;
    }

    public void setDataAdendada(Date dataAdendada) {
        this.dataAdendada = dataAdendada;
    }
}
