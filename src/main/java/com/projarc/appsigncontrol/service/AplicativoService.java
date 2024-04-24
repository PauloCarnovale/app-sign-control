package com.projarc.appsigncontrol.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.projarc.appsigncontrol.model.AplicativoModel;
import com.projarc.appsigncontrol.repository.AplicativoRepository;

public class AplicativoService {
    private AplicativoRepository aplicativoRepository;
    
    @Autowired
    public AplicativoService(AplicativoRepository aplicativoRepository){
        this.aplicativoRepository = aplicativoRepository;
    }
 
    public List<AplicativoModel> getAll(){
        return this.aplicativoRepository.getAll().stream()
        .map(p->ProdutoDTO.fromModel(p))
        .toList();
    }
}
