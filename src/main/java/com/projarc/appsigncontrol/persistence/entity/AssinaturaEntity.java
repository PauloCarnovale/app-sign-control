package com.projarc.appsigncontrol.persistence.entity;

import com.projarc.appsigncontrol.application.dto.AssinaturaDto;
import com.projarc.appsigncontrol.domain.model.AssinaturaModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

    @Column(name = "inicio_vigencia", nullable = false)
    private String inicioVigencia;

    @Column(name = "fimVigencia", nullable = false)
    private String fimVigencia;

    public AssinaturaEntity() {

    }

    public AssinaturaEntity(long id, AplicativoEntity aplicativo, ClienteEntity cliente, String inicioVigencia,
            String fimVigencia) {
        this.id = id;
        this.aplicativo = aplicativo;
        this.cliente = cliente;
        this.inicioVigencia = inicioVigencia;
        this.fimVigencia = fimVigencia;
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

    public String getInicioVigencia() {
        return this.inicioVigencia;
    }

    public void setInicioVigencia(String inicioVigencia) {
        this.inicioVigencia = inicioVigencia;
    }

    public String getFimVigencia() {
        return this.fimVigencia;
    }

    public void setDataFim(String fimVigencia) {
        this.fimVigencia = fimVigencia;
    }

    public static AssinaturaEntity fromAssinaturaModel(AssinaturaModel assinaturaModel) {
        return new AssinaturaEntity(assinaturaModel.getId(), assinaturaModel.getAplicativo(),
                assinaturaModel.getCliente(), assinaturaModel.getDataInicio(), assinaturaModel.getDataFim());
    }

    public static AssinaturaModel toAssinaturaModel(AssinaturaEntity assinaturaEntity) {
        return new AssinaturaModel(assinaturaEntity.getId(), assinaturaEntity.getAplicativo(),
                assinaturaEntity.getCliente(), assinaturaEntity.getInicioVigencia(), assinaturaEntity.getFimVigencia());
    }

    public static AssinaturaDto toAssinaturaDto(AssinaturaEntity assinaturaEntity) {
        return new AssinaturaDto(assinaturaEntity.getId(), assinaturaEntity.getAplicativo().getId(),
                assinaturaEntity.getCliente().getId(), assinaturaEntity.getInicioVigencia(),
                assinaturaEntity.getFimVigencia());
    }
}
