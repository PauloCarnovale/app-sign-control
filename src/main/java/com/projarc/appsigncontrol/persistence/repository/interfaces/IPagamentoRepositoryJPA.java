package com.projarc.appsigncontrol.persistence.repository.interfaces;

import com.projarc.appsigncontrol.domain.entity.PagamentoEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IPagamentoRepositoryJPA extends JpaRepository<PagamentoEntity, Long> {
    List<PagamentoEntity> findAll();

    PagamentoEntity getReferenceById(long id);

    PagamentoEntity saveAndFlush(PagamentoEntity pagamento);
}
