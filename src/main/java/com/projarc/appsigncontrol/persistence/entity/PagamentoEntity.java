package com.projarc.appsigncontrol.persistence.entity;

import com.projarc.appsigncontrol.application.dto.PagamentoDto;
import com.projarc.appsigncontrol.domain.model.PagamentoModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pagamentos")
public class PagamentoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne()
    @JoinColumn(name = "id_assinatura")
    private AssinaturaEntity assinatura;

    @Column(name = "valorPago", nullable = false)
    private double valorPago;

    @Column(name = "data_pagamento", nullable = false)
    private String dataPagamento;

    @Column(name = "promocao", nullable = false, length = 255)
    private String promocao;

    public PagamentoEntity(long id, AssinaturaEntity assinatura, double valorPago, String dataPagamento,
            String promocao) {
        this.id = id;
        this.assinatura = assinatura;
        this.valorPago = valorPago;
        this.dataPagamento = dataPagamento;
        this.promocao = promocao;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public AssinaturaEntity getAssinatura() {
        return this.assinatura;
    }

    public void setAssinatura(AssinaturaEntity assinatura) {
        this.assinatura = assinatura;
    }

    public double getValorPago() {
        return this.valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public String getDataPagamento() {
        return this.dataPagamento;
    }

    public void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getPromocao() {
        return this.promocao;
    }

    public void setPromocao(String promocao) {
        this.promocao = promocao;
    }

    public static PagamentoEntity fromPagamentoModel(PagamentoModel pagamentoModel) {
        return new PagamentoEntity(pagamentoModel.getId(), pagamentoModel.getAssinatura(),
                pagamentoModel.getValorPago(), pagamentoModel.getDataPagamento(), pagamentoModel.getPromocao());
    }

    public static PagamentoModel toPagamentoModel(PagamentoEntity pagamentoEntity) {
        return new PagamentoModel(pagamentoEntity.getId(), pagamentoEntity.getAssinatura(),
                pagamentoEntity.getValorPago(), pagamentoEntity.getDataPagamento(), pagamentoEntity.getPromocao());
    }

    public static PagamentoDto toPagamentoDto(PagamentoEntity pagamentoEntity) {
        return new PagamentoDto(pagamentoEntity.getId(), pagamentoEntity.getAssinatura(),
                pagamentoEntity.getValorPago(), pagamentoEntity.getDataPagamento(), pagamentoEntity.getPromocao());
    }
}
