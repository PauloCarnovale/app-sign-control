package com.projarc.appsigncontrol.domain.service;

import java.security.InvalidParameterException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projarc.appsigncontrol.application.dto.AssinaturaDto;
import com.projarc.appsigncontrol.domain.model.AssinaturaModel;
import com.projarc.appsigncontrol.enums.AssinaturaStatus;
import com.projarc.appsigncontrol.persistence.entity.AplicativoEntity;
import com.projarc.appsigncontrol.persistence.entity.AssinaturaEntity;
import com.projarc.appsigncontrol.persistence.entity.ClienteEntity;
import com.projarc.appsigncontrol.persistence.repository.AplicativoRepository;
import com.projarc.appsigncontrol.persistence.repository.AssinaturaRepository;
import com.projarc.appsigncontrol.persistence.repository.ClienteRepository;

import java.util.stream.Collectors;

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

    public List<AssinaturaModel> getAll() {
        List<AssinaturaEntity> assinaturas = this.assinaturaRepository.findAll();
        if (assinaturas.size() == 0) {
            return new LinkedList<AssinaturaModel>();
        } else {
            return assinaturas.stream()
                    .map(assinatura -> AssinaturaEntity.toAssinaturaModel(assinatura))
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

    public List<AssinaturaModel> getByType(String type) {
        List<AssinaturaEntity> assinaturas = this.assinaturaRepository.findAll();
        List<AssinaturaModel> assinaturasModel = assinaturas.stream()
                .map(assinatura -> AssinaturaEntity.toAssinaturaModel(assinatura))
                .toList();

        if (AssinaturaStatus.getType(type) == AssinaturaStatus.ATIVA) {
            assinaturasModel = assinaturasModel.stream()
                    .filter(assinatura -> assinatura.getStatus() == AssinaturaStatus.ATIVA)
                    .collect(Collectors.toList());
            return assinaturasModel;
        }

        if (AssinaturaStatus.getType(type) == AssinaturaStatus.CANCELADA) {
            assinaturasModel = assinaturasModel.stream()
                    .filter(assinatura -> assinatura.getStatus() == AssinaturaStatus.CANCELADA)
                    .collect(Collectors.toList());
            return assinaturasModel;
        }

        return assinaturasModel;

    }

    public List<AssinaturaModel> getByClient(int id) {
        List<AssinaturaEntity> assinaturas = this.assinaturaRepository.findAll();

        List<AssinaturaModel> assinaturasModel = assinaturas.stream()
                .map(assinatura -> AssinaturaEntity.toAssinaturaModel(assinatura))
                .toList();

        List<AssinaturaModel> filteredAssinaturas = assinaturasModel.stream()
                .filter(assinatura -> assinatura.getCliente().getId() == id)
                .collect(Collectors.toList());

        return filteredAssinaturas;
    }

    public List<AssinaturaModel> getByApp(int id) {
        List<AssinaturaEntity> assinaturas = this.assinaturaRepository.findAll();

        List<AssinaturaModel> assinaturasModel = assinaturas.stream()
                .map(assinatura -> AssinaturaEntity.toAssinaturaModel(assinatura))
                .toList();

        List<AssinaturaModel> filteredAssinaturas = assinaturasModel.stream()
                .filter(assinatura -> assinatura.getAplicativo().getId() == id)
                .collect(Collectors.toList());

        return filteredAssinaturas;
    }

    public AssinaturaDto create(AssinaturaDto payload) {
        AplicativoEntity aplicativo = aplicativoRepository.getReferenceById(payload.getIdAplicativo());
        ClienteEntity cliente = clienteRepository.getReferenceById(payload.getIdCliente());
        if (aplicativo == null || cliente == null)
            throw new InvalidParameterException();

        AssinaturaEntity assinaturaEntity = new AssinaturaEntity();
        assinaturaEntity.setAplicativo(aplicativo);
        assinaturaEntity.setCliente(cliente);
        assinaturaEntity.setInicioVigencia(LocalDate.now());
        // Sempre que uma assinatura for cadastrada, o cliente ganha 7 dias grátis
        assinaturaEntity.setDataFim(assinaturaEntity.getInicioVigencia().plusDays(7));

        AssinaturaEntity createdAssinatura = this.assinaturaRepository.saveAndFlush(assinaturaEntity);
        return AssinaturaEntity.toAssinaturaDto(createdAssinatura);
    }
}
