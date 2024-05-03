package com.projarc.appsigncontrol.domain.model;

import com.projarc.appsigncontrol.application.dto.PagamentoDto;
import com.projarc.appsigncontrol.persistence.entity.AssinaturaEntity;

public class PagamentoModel {
    private long id;

    private AssinaturaEntity assinatura;

    private double valorPago;

    private String dataPagamento;

    private String promocao;

    public PagamentoModel(long id, AssinaturaEntity assinatura, double valorPago, String dataPagamento,
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

    public static PagamentoDto fromModel(PagamentoModel pagamentoModel) {
        return new PagamentoDto(pagamentoModel.getId(), pagamentoModel.getAssinatura(),
                pagamentoModel.getValorPago(), pagamentoModel.getDataPagamento(), pagamentoModel.getPromocao());
    }
}
