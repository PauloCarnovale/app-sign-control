package com.projarc.appsigncontrol.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projarc.appsigncontrol.dto.AplicativoDto;
import com.projarc.appsigncontrol.entity.AplicativoEntity;
import com.projarc.appsigncontrol.model.AplicativoModel;
import com.projarc.appsigncontrol.repository.AplicativoRepository;

@Service
public class AplicativoService {
    @Autowired
    private AplicativoRepository aplicativoRepository;
    
    public AplicativoService(AplicativoRepository aplicativoRepository){
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
            return null;
        } else {
            return AplicativoEntity.toAplicativoModel(aplicativo);
        }
    }

    public AplicativoEntity create(AplicativoDto payload) {
        AplicativoEntity aplicativoEntity = new AplicativoEntity(payload.getId(), payload.getDescricao());
        return this.aplicativoRepository.saveAndFlush(aplicativoEntity);
    }
}
