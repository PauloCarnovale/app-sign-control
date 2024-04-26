package com.projarc.appsigncontrol.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

import com.projarc.appsigncontrol.entity.AssinaturaEntity;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AssinaturaRepository extends JpaRepository<AssinaturaEntity, Long> {
    List<AssinaturaEntity> findAll();

    AssinaturaEntity getReferenceById(long id);

    AssinaturaEntity saveAndFlush(AssinaturaEntity assinatura);
}
