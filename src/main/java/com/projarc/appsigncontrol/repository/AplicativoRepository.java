package com.projarc.appsigncontrol.repository;

import org.springframework.stereotype.Repository;

import java.util.List;
import com.projarc.appsigncontrol.dto.AplicativoDto;
import com.projarc.appsigncontrol.entity.AplicativoEntity;

import org.springframework.data.repository.CrudRepository;

@Repository
public class AplicativoRepository extends CrudRepository<AplicativoDto, Long> {
    List<AplicativoDto> findAll();
}
