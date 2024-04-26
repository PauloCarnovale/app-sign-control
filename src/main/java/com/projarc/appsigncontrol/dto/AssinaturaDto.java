package com.projarc.appsigncontrol.dto;

import com.projarc.appsigncontrol.entity.AplicativoEntity;
import com.projarc.appsigncontrol.entity.ClienteEntity;

public class AssinaturaDto {
    private long id;
    private AplicativoEntity aplicativo;
    private ClienteEntity cliente;
    private String dataInicio;
    private String dataFim;

    public AssinaturaDto(long id, AplicativoEntity aplicativo, ClienteEntity cliente, String dataInicio,
            String dataFim) {
        this.id = id;
        this.aplicativo = aplicativo;
        this.cliente = cliente;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public AplicativoEntity getAplicativo() {
        return this.aplicativo;
    }

    public long getId() {
        return this.id;
    }

    public ClienteEntity getCliente() {
        return this.cliente;
    }

    public String getDataInicio() {
        return this.dataInicio;
    }

    public String getDataFim() {
        return this.dataFim;
    }
}
