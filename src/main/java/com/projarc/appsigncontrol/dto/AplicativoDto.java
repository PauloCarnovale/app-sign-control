package com.projarc.appsigncontrol.dto;

public class AplicativoDto {
    private long id;
    private String descricao;

    public AplicativoDto(long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public long getId() {
        return this.id;
    }

    public String getDescricao() {
        return this.descricao;
    }

}
