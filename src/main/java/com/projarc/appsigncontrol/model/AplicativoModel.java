package com.projarc.appsigncontrol.model;

import com.projarc.appsigncontrol.dto.AplicativoDto;


public class AplicativoModel {
    
    private long id;
    private String descricao;

    public AplicativoModel(long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public long getId() {
        return this.id;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public static AplicativoDto fromModel(AplicativoModel aplicativoModel){
        return new AplicativoDto(aplicativoModel.getId(), aplicativoModel.getDescricao());
    }
}
