package com.projarc.appsigncontrol.repository;

import org.springframework.stereotype.Repository;

import java.util.List;
import com.projarc.appsigncontrol.entity.ClienteEntity;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
    List<ClienteEntity> findAll();

    ClienteEntity getReferenceById(long id);

    ClienteEntity saveAndFlush(ClienteEntity cliente);
}
