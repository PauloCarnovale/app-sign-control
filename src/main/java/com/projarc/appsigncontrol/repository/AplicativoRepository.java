package com.projarc.appsigncontrol.repository;

import org.springframework.stereotype.Repository;

import java.util.List;
import com.projarc.appsigncontrol.entity.AplicativoEntity;

import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface AplicativoRepository extends JpaRepository<AplicativoEntity, Long> {
    List<AplicativoEntity> findAll();

    AplicativoEntity getReferenceById(long id);

    AplicativoEntity saveAndFlush(AplicativoEntity aplicativo);
}
