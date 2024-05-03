package com.projarc.appsigncontrol.persistence.repository;

import org.springframework.stereotype.Repository;

import com.projarc.appsigncontrol.persistence.entity.AssinaturaEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AssinaturaRepository extends JpaRepository<AssinaturaEntity, Long> {
    List<AssinaturaEntity> findAll();

    AssinaturaEntity getReferenceById(long id);

    AssinaturaEntity saveAndFlush(AssinaturaEntity assinatura);
}
