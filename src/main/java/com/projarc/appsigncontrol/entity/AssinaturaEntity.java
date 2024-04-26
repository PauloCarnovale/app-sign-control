package com.projarc.appsigncontrol.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.projarc.appsigncontrol.model.AssinaturaModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "assinaturas")
public class AssinaturaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne()
    @JoinColumn(name = "id_aplicativo")
    private AplicativoEntity aplicativo;

    @ManyToOne()
    @JoinColumn(name = "id_cliente")
    private ClienteEntity cliente;

    @Column(name = "data_inicio", nullable = false)
    private String dataInicio;

    @Column(name = "data_fim", nullable = false)
    private String dataFim;

    public AssinaturaEntity() {

    }

    public AssinaturaEntity(long id, AplicativoEntity aplicativo, ClienteEntity cliente, String dataInicio,
            String dataFim) {
        this.id = id;
        this.aplicativo = aplicativo;
        this.cliente = cliente;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public long getId() {
        return this.id;
    }

    public AplicativoEntity getAplicativo() {
        return this.aplicativo;
    }

    public ClienteEntity getCliente() {
        return this.cliente;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAplicativo(AplicativoEntity aplicativo) {
        this.aplicativo = aplicativo;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public String getDataInicio() {
        return this.dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return this.dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public static AssinaturaEntity fromAssinaturaModel(AssinaturaModel assinaturaModel) {
        return new AssinaturaEntity(assinaturaModel.getId(), assinaturaModel.getAplicativo(),
                assinaturaModel.getCliente(), assinaturaModel.getDataInicio(), assinaturaModel.getDataFim());
    }

    public static AssinaturaModel toAssinaturaModel(AssinaturaEntity assinaturaEntity) {
        return new AssinaturaModel(assinaturaEntity.getId(), assinaturaEntity.getAplicativo(),
                assinaturaEntity.getCliente(), assinaturaEntity.getDataInicio(), assinaturaEntity.getDataFim());
    }
}
