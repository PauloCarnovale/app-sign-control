package com.projarc.appsigncontrol.dto;

import java.util.Date;

public class AssinaturaDto {
    private long id;
    private int idAplicativo;
    private int idCliente;
    private Date dataInicio;
    private Date dataFim;

    public AssinaturaDto(int idAplicativo, int idCliente, Date dataInicio, Date dataFim) {
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

    public Date getDataInicio() {
        return this.dataInicio;
    }

    public Date getDataFim() {
        return this.dataFim;
    }
}
