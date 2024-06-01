package com.projarc.appsigncontrol.persistence.repository.interfaces;

import com.projarc.appsigncontrol.domain.entity.AplicativoEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IAplicativoRepositoryJPA extends JpaRepository<AplicativoEntity, Long> {
    List<AplicativoEntity> findAll();

    AplicativoEntity getReferenceById(long id);

    AplicativoEntity saveAndFlush(AplicativoEntity aplicativo);
}
