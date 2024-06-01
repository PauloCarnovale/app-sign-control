package com.projarc.appsigncontrol.persistence.repository.interfaces;

import com.projarc.appsigncontrol.domain.entity.ClienteEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepositoryJPA extends JpaRepository<ClienteEntity, Long> {
    List<ClienteEntity> findAll();

    ClienteEntity getReferenceById(long id);

    ClienteEntity saveAndFlush(ClienteEntity cliente);
}
