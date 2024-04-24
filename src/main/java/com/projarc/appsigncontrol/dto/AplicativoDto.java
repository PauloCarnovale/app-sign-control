package com.projarc.appsigncontrol.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class AplicativoDto {
    @Id
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

    public void setId(long id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
