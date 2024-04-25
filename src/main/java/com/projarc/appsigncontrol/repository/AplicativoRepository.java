package com.projarc.appsigncontrol.repository;

import org.springframework.stereotype.Repository;

import java.util.List;
import com.projarc.appsigncontrol.entity.AplicativoEntity;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface AplicativoRepository extends CrudRepository<AplicativoEntity, Long> {
    List<AplicativoEntity>findAll();
    AplicativoEntity findById(long id);
}
