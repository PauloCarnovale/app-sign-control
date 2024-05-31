package com.projarc.appsigncontrol.domain.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projarc.appsigncontrol.application.dto.AplicativoDto;
import com.projarc.appsigncontrol.domain.model.AplicativoModel;
import com.projarc.appsigncontrol.persistence.entity.AplicativoEntity;
import com.projarc.appsigncontrol.persistence.repository.AplicativoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AplicativoService {
    @Autowired
    private AplicativoRepository aplicativoRepository;

    public AplicativoService(AplicativoRepository aplicativoRepository) {
        this.aplicativoRepository = aplicativoRepository;
    }

    public List<AplicativoModel> getAll() {
        List<AplicativoEntity> aplicativos = aplicativoRepository.findAll();
        if (aplicativos.size() == 0) {
            return new LinkedList<AplicativoModel>();
        } else {
            return aplicativos.stream()
                    .map(app -> AplicativoEntity.toAplicativoModel(app))
                    .toList();
        }
    }

    public AplicativoModel getById(long id) {
        AplicativoEntity aplicativo = aplicativoRepository.getReferenceById(id);
        if (aplicativo == null) {
            throw new EntityNotFoundException("Entity not found");
        } else {
            return AplicativoEntity.toAplicativoModel(aplicativo);
        }
    }

    public AplicativoEntity create(AplicativoDto payload) {
        AplicativoEntity aplicativoEntity = new AplicativoEntity(payload.getNome(),
                payload.getCustoMensal());
        return this.aplicativoRepository.saveAndFlush(aplicativoEntity);
    }

    public AplicativoEntity update(long id, AplicativoDto payload) {
        AplicativoEntity aplicativoEntity = this.aplicativoRepository.getReferenceById(id);
        if (aplicativoEntity == null) {
            throw new EntityNotFoundException("Entity not found");
        }
        aplicativoEntity.setCustoMensal(payload.getCustoMensal());
        return this.aplicativoRepository.saveAndFlush(aplicativoEntity);
    }
}
