package com.projarc.appsigncontrol.controller;

import com.projarc.appsigncontrol.dto.ClienteDto;
import com.projarc.appsigncontrol.entity.ClienteEntity;
import com.projarc.appsigncontrol.model.ClienteModel;
import com.projarc.appsigncontrol.service.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    @GetMapping
    @CrossOrigin(origins = "*")
    public List<ClienteModel> getAll() {
        return this.clienteService.getAll();
    }
    
    @GetMapping("/{id}")
    @CrossOrigin(origins = "*")
    public ClienteModel getById(@PathVariable Long id) {
        return this.clienteService.getById(id);
    }
    
    @PostMapping
    @CrossOrigin(origins = "*")
    public ClienteEntity create(@RequestBody ClienteDto payload) {
        return this.clienteService.create(payload);
    }
}