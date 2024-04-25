package com.projarc.appsigncontrol.entity;

import com.projarc.appsigncontrol.model.AplicativoModel;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class AplicativoEntity {
    @Id
    private long id;
    private String descricao;

    protected AplicativoEntity(){ }

    public AplicativoEntity(long id, String descricao) {
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

    public static AplicativoEntity fromAplicativoModel(AplicativoModel aplicativoModel) {
        return new AplicativoEntity(aplicativoModel.getId(), aplicativoModel.getDescricao());
    }
    
    public static AplicativoModel toAplicativoModel(AplicativoEntity aplicativoEntity){
        return new AplicativoModel(aplicativoEntity.getId(),aplicativoEntity.getDescricao());
    }
}
