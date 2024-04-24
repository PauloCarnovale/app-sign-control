package com.projarc.appsigncontrol.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class AssinaturaEntity {
    @Id
    private long id;
    private int idAplicativo;
    private int idCliente;
    private Date dataInicio;
    private Date dataFim;

    public AssinaturaEntity(int idAplicativo, int idCliente, Date dataInicio, Date dataFim) {
        this.idAplicativo = idAplicativo;
        this.idCliente = idCliente;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public int getAplicativo() {
        return this.idAplicativo;
    }

    public long getId() {
        return this.id;
    }

    public int getCliente() {
        return this.idCliente;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setIdAplicativo(int idAplicativo) {
        this.idAplicativo = idAplicativo;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Date getDataInicio() {
        return this.dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return this.dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

}
