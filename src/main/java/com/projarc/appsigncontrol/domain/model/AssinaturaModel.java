package com.projarc.appsigncontrol.domain.model;

import java.time.LocalDate;

import com.projarc.appsigncontrol.enums.AssinaturaStatus;
import com.projarc.appsigncontrol.persistence.entity.AplicativoEntity;
import com.projarc.appsigncontrol.persistence.entity.ClienteEntity;

public class AssinaturaModel {
    private long id;
    private AplicativoEntity aplicativo;
    private ClienteEntity cliente;
    private LocalDate inicioVigencia;
    private LocalDate fimVigencia;

    private AssinaturaStatus status;

    public AssinaturaModel(long id, AplicativoEntity aplicativo, ClienteEntity cliente, LocalDate inicioVigencia,
            LocalDate fimVigencia) {
        this.id = id;
        this.aplicativo = aplicativo;
        this.cliente = cliente;
        this.inicioVigencia = inicioVigencia;
        this.fimVigencia = fimVigencia;

        if (fimVigencia.isAfter(LocalDate.now())) {
            this.status = AssinaturaStatus.ATIVA;
        } else {
            this.status = AssinaturaStatus.INATIVA;
        }
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

    public LocalDate getDataInicio() {
        return this.inicioVigencia;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.inicioVigencia = dataInicio;
    }

    public LocalDate getDataFim() {
        return this.fimVigencia;
    }

    public void setDataFim(LocalDate dataFim) {
        this.fimVigencia = dataFim;
    }

    public AssinaturaStatus getStatus() {
        return this.status;
    }

    public static AssinaturaModel fromModel(AssinaturaModel assinaturaModel) {
        return new AssinaturaModel(assinaturaModel.getId(), assinaturaModel.getAplicativo(),
                assinaturaModel.getCliente(), assinaturaModel.getDataInicio(), assinaturaModel.getDataFim());
    }
}
