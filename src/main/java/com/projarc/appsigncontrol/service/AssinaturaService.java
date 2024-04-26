package com.projarc.appsigncontrol.service;

import java.security.InvalidParameterException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projarc.appsigncontrol.dto.AssinaturaDto;
import com.projarc.appsigncontrol.entity.AplicativoEntity;
import com.projarc.appsigncontrol.entity.AssinaturaEntity;
import com.projarc.appsigncontrol.entity.ClienteEntity;
import com.projarc.appsigncontrol.model.AssinaturaModel;
import com.projarc.appsigncontrol.repository.AplicativoRepository;
import com.projarc.appsigncontrol.repository.AssinaturaRepository;
import com.projarc.appsigncontrol.repository.ClienteRepository;

@Service
public class AssinaturaService {
    @Autowired
    private AssinaturaRepository assinaturaRepository;
    private AplicativoRepository aplicativoRepository;
    private ClienteRepository clienteRepository;

    public AssinaturaService(AssinaturaRepository assinaturaRepository, AplicativoRepository aplicativoRepository,
            ClienteRepository clienteRepository) {
        this.assinaturaRepository = assinaturaRepository;
        this.aplicativoRepository = aplicativoRepository;
        this.clienteRepository = clienteRepository;
    }

    public List<AssinaturaDto> getAll() {
        List<AssinaturaEntity> assinaturas = this.assinaturaRepository.findAll();
        if (assinaturas.size() == 0) {
            return new LinkedList<AssinaturaDto>();
        } else {
            return assinaturas.stream()
                    .map(assinatura -> AssinaturaEntity.toAssinaturaDto(assinatura))
                    .toList();
        }
    }

    public AssinaturaDto getById(long id) {
        AssinaturaEntity assinatura = assinaturaRepository.getReferenceById(id);
        if (assinatura == null) {
            return null;
        } else {
            return AssinaturaEntity.toAssinaturaDto(assinatura);
        }
    }

    public AssinaturaEntity create(AssinaturaDto payload) {
        AplicativoEntity aplicativo = aplicativoRepository.getReferenceById(payload.getAplicativo());
        ClienteEntity cliente = clienteRepository.getReferenceById(payload.getCliente());
        if (aplicativo == null || cliente == null)
            throw new InvalidParameterException();

        AssinaturaEntity assinaturaEntity = new AssinaturaEntity(payload.getId(), aplicativo,
                cliente, payload.getDataInicio(), payload.getDataFim());
        return this.assinaturaRepository.saveAndFlush(assinaturaEntity);
    }
}
