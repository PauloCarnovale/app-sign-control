package com.projarc.appsigncontrol.entity;

import com.projarc.appsigncontrol.model.ClienteModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")
public class ClienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "email", nullable = false, length = 255)
    private String email;

    public ClienteEntity() {
    }

    public ClienteEntity(long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public static ClienteEntity fromClienteModel(ClienteModel clienteModel) {
        return new ClienteEntity(clienteModel.getId(), clienteModel.getName(), clienteModel.getEmail());
    }

    public static ClienteModel toClienteModel(ClienteEntity clienteEntity) {
        return new ClienteModel(clienteEntity.getId(), clienteEntity.getName(), clienteEntity.getEmail());
    }
}
