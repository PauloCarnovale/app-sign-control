package com.projarc.appsigncontrol.dto;

public class AssinaturaDto {
    private long id;
    private long idAplicativo;
    private long idCliente;
    private String dataInicio;
    private String dataFim;

    public AssinaturaDto(long id, long idAplicativo, long idCliente, String dataInicio,
            String dataFim) {
        this.id = id;
        this.idAplicativo = idAplicativo;
        this.idCliente = idCliente;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public long getAplicativo() {
        return this.idAplicativo;
    }

    public long getId() {
        return this.id;
    }

    public long getCliente() {
        return this.idCliente;
    }

    public String getDataInicio() {
        return this.dataInicio;
    }

    public String getDataFim() {
        return this.dataFim;
    }
}
