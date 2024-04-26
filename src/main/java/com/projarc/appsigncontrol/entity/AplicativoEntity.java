package com.projarc.appsigncontrol.entity;

import com.projarc.appsigncontrol.model.AplicativoModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "aplicativos")
public class AplicativoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "descricao", nullable = false, length = 255)
    private String descricao;

    public AplicativoEntity(long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public AplicativoEntity() {
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

    public static AplicativoModel toAplicativoModel(AplicativoEntity app) {
        return new AplicativoModel(app.getId(), app.getDescricao());
    }
}
