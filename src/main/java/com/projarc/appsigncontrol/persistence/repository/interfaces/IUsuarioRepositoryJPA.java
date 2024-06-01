package com.projarc.appsigncontrol.persistence.repository.interfaces;

import com.projarc.appsigncontrol.domain.entity.UsuarioEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepositoryJPA extends JpaRepository<UsuarioEntity, Long> {
    List<UsuarioEntity> findAll();

    UsuarioEntity getReferenceById(long id);

    UsuarioEntity saveAndFlush(UsuarioEntity usuario);

    void deleteAllByIdInBatch(Iterable<Long> ids);
}
