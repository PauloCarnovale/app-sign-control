package com.projarc.appsigncontrol.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class AplicativoEntity {
    @Id
    private long id;
    private String descricao;

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
}
