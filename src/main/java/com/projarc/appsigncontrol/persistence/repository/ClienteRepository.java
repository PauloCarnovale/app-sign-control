package com.projarc.appsigncontrol.persistence.repository;

import org.springframework.stereotype.Repository;

import com.projarc.appsigncontrol.persistence.entity.ClienteEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
    List<ClienteEntity> findAll();

    ClienteEntity getReferenceById(long id);

    ClienteEntity saveAndFlush(ClienteEntity cliente);
}
