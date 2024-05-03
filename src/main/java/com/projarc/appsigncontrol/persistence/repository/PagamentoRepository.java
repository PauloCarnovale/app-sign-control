package com.projarc.appsigncontrol.persistence.repository;

import org.springframework.stereotype.Repository;

import com.projarc.appsigncontrol.persistence.entity.PagamentoEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PagamentoRepository extends JpaRepository<PagamentoEntity, Long> {
    List<PagamentoEntity> findAll();

    PagamentoEntity getReferenceById(long id);

    PagamentoEntity saveAndFlush(PagamentoEntity pagamento);
}
