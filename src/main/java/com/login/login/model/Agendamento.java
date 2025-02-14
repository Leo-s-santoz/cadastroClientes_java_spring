// Agendamento.java
package com.login.login.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

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

    @NotEmpty
    private String email;

    private String observacao;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;

    @NotEmpty
    private String data_agendada;

    @NotEmpty
    private String hora_agendada;

    @Enumerated(EnumType.STRING)
    private StatusAgendamento status;

    @PrePersist
    protected void onCreate() {
        dataCriacao = new Date();
        if (status == null) {
            status = StatusAgendamento.AGENDADO;
        }
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getData_agendada() {
        return data_agendada;
    }

    public void setData_agendada(String data_agendada) {
        this.data_agendada = data_agendada;
    }

    public String getHora_agendada() {
        return hora_agendada;
    }

    public void setHora_agendada(String hora_agendada) {
        this.hora_agendada = hora_agendada;
    }

    public StatusAgendamento getStatus() {
        return status;
    }

    public void setStatus(StatusAgendamento status) {
        this.status = status;
    }
}