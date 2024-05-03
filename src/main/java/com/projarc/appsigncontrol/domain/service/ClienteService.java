package com.projarc.appsigncontrol.domain.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projarc.appsigncontrol.application.dto.ClienteDto;
import com.projarc.appsigncontrol.domain.model.ClienteModel;
import com.projarc.appsigncontrol.persistence.entity.ClienteEntity;
import com.projarc.appsigncontrol.persistence.repository.ClienteRepository;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<ClienteModel> getAll() {
        List<ClienteEntity> clientes = this.clienteRepository.findAll();
        if (clientes.size() == 0) {
            return new LinkedList<ClienteModel>();
        } else {
            return clientes.stream()
                    .map(cliente -> ClienteEntity.toClienteModel(cliente))
                    .toList();
        }
    }

    public ClienteModel getById(long id) {
        ClienteEntity cliente = clienteRepository.getReferenceById(id);
        if (cliente == null) {
            return null;
        } else {
            return ClienteEntity.toClienteModel(cliente);
        }
    }

    public ClienteEntity create(ClienteDto payload) {
        ClienteEntity clienteModel = new ClienteEntity(payload.getId(), payload.getName(), payload.getEmail());
        return this.clienteRepository.saveAndFlush(clienteModel);
    }
}
