package com.projarc.appsigncontrol.model;

import com.projarc.appsigncontrol.entity.AplicativoEntity;
import com.projarc.appsigncontrol.entity.ClienteEntity;

public class AssinaturaModel {
    private long id;
    private AplicativoEntity aplicativo;
    private ClienteEntity cliente;
    private String dataInicio;
    private String dataFim;

    public AssinaturaModel(long id, AplicativoEntity aplicativo, ClienteEntity cliente, String dataInicio,
            String dataFim) {
        this.id = id;
        this.aplicativo = aplicativo;
        this.cliente = cliente;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public long getId() {
        return this.id;
    }

    public AplicativoEntity getAplicativo() {
        return this.aplicativo;
    }

    public ClienteEntity getCliente() {
        return this.cliente;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAplicativo(AplicativoEntity aplicativo) {
        this.aplicativo = aplicativo;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public String getDataInicio() {
        return this.dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return this.dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public static AssinaturaModel fromModel(AssinaturaModel assinaturaModel) {
        return new AssinaturaModel(assinaturaModel.getId(), assinaturaModel.getAplicativo(),
                assinaturaModel.getCliente(), assinaturaModel.getDataInicio(), assinaturaModel.getDataFim());
    }
}
