package com.projarc.appsigncontrol.application.dto;

public class AssinaturaDto {
    private long id;
    private long idAplicativo;
    private long idCliente;
    private String inicioVigencia;
    private String fimVigencia;

    public AssinaturaDto(long id, long idAplicativo, long idCliente, String inicioVigencia, String fimVigencia) {
        this.id = id;
        this.idAplicativo = idAplicativo;
        this.idCliente = idCliente;
        this.inicioVigencia = inicioVigencia;
        this.fimVigencia = fimVigencia;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdAplicativo() {
        return this.idAplicativo;
    }

    public void setIdAplicativo(long idAplicativo) {
        this.idAplicativo = idAplicativo;
    }

    public long getIdCliente() {
        return this.idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    public String getInicioVigencia() {
        return this.inicioVigencia;
    }

    public void setInicioVigencia(String inicioVigencia) {
        this.inicioVigencia = inicioVigencia;
    }

    public String getFimVigencia() {
        return this.fimVigencia;
    }

    public void setFimVigencia(String fimVigencia) {
        this.fimVigencia = fimVigencia;
    }

}
