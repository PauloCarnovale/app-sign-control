package com.projarc.appsigncontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projarc.appsigncontrol.dto.AplicativoDto;

import jakarta.persistence.Id;

@Repository
public class AplicativoRepository extends JpaRepository<AplicativoDto, Id> {
    
}
