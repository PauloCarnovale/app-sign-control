package com.projarc.appsigncontrol.persistence.repository;

import org.springframework.stereotype.Repository;

import com.projarc.appsigncontrol.persistence.entity.AplicativoEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AplicativoRepository extends JpaRepository<AplicativoEntity, Long> {
    List<AplicativoEntity> findAll();

    AplicativoEntity getReferenceById(long id);

    AplicativoEntity saveAndFlush(AplicativoEntity aplicativo);
}
