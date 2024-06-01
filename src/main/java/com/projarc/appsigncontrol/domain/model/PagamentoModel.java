package com.projarc.appsigncontrol.domain.model;

import com.projarc.appsigncontrol.application.dto.PagamentoDto;
import com.projarc.appsigncontrol.persistence.entity.AssinaturaEntity;

import java.time.LocalDate;

import com.projarc.appsigncontrol.enums.PagamentoStatus;

public class PagamentoModel {
    private long id;

    private long assinaturaId;

    private double valorPago;

    private LocalDate dataPagamento;

    private String promocao;

    private PagamentoStatus status;

    private double valorEstornado;

    // public PagamentoModel(long id, AssinaturaEntity assinatura, double valorPago,
    // LocalDate dataPagamento,
    // String promocao) {
    // this.id = id;
    // this.assinatura = assinatura;
    // this.valorPago = valorPago;
    // this.dataPagamento = dataPagamento;
    // this.promocao = promocao;
    // }

    public PagamentoModel(Long id, long assinaturaId, double valorPago,
            LocalDate dataPagamento,
            String promocao, PagamentoStatus status, double valorEstornado) {
        this.id = id;
        this.assinaturaId = assinaturaId;
        this.valorPago = valorPago;
        this.dataPagamento = dataPagamento;
        this.promocao = promocao;
        this.status = status;
        this.valorEstornado = valorEstornado;
    }

    // public PagamentoModel(long id, long assinaturaId, double valorPago, LocalDate
    // dataPagamento,
    // String promocao) {
    // this.id = id;
    // this.assinaturaId = assinaturaId;
    // this.valorPago = valorPago;
    // this.dataPagamento = dataPagamento;
    // this.promocao = promocao;
    // }

    public long getId() {
        return this.id;
    }

    public long getAssinaturaId() {
        return this.assinaturaId;
    }

    public double getValorPago() {
        return this.valorPago;
    }

    public LocalDate getDataPagamento() {
        return this.dataPagamento;
    }

    public String getPromocao() {
        return this.promocao;
    }

    public double getValorEstornado() {
        return this.valorEstornado;
    }

    public PagamentoStatus getStatus() {
        return this.status;
    }
}
