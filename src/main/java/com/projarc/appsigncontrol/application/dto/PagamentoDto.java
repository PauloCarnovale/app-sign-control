package com.projarc.appsigncontrol.application.dto;

import com.projarc.appsigncontrol.persistence.entity.AssinaturaEntity;

public class PagamentoDto {
    private long id;

    private AssinaturaEntity assinatura;

    private double valorPago;

    private String dataPagamento;

    private String promocao;

    public PagamentoDto(long id, AssinaturaEntity assinatura, double valorPago, String dataPagamento,
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

    public AssinaturaEntity getAssinatura() {
        return this.assinatura;
    }

    public double getValorPago() {
        return this.valorPago;
    }

    public String getDataPagamento() {
        return this.dataPagamento;
    }

    public String getPromocao() {
        return this.promocao;
    }

}
