package com.projarc.appsigncontrol.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projarc.appsigncontrol.model.AplicativoModel;
import com.projarc.appsigncontrol.repository.AplicativoRepository;

@Service
public class AplicativoService {
    private AplicativoRepository aplicativoRepository;
    
    @Autowired
    public AplicativoService(AplicativoRepository aplicativoRepository){
        this.aplicativoRepository = aplicativoRepository;
    }
 
    public List<AplicativoModel> getAll(){
        return this.aplicativoRepository.findAll().stream()
        .map(p->AplicativoEntity.fromModel(p))
        .toList();
    }
}
