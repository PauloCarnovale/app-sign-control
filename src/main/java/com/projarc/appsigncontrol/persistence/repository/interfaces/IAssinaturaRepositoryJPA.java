package com.projarc.appsigncontrol.persistence.repository.interfaces;

import org.springframework.stereotype.Repository;

import com.projarc.appsigncontrol.domain.entity.AssinaturaEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IAssinaturaRepositoryJPA extends JpaRepository<AssinaturaEntity, Long> {
    List<AssinaturaEntity> findAll();

    AssinaturaEntity getReferenceById(long id);

    AssinaturaEntity saveAndFlush(AssinaturaEntity assinatura);
}
