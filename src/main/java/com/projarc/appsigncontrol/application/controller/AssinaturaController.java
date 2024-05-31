package com.projarc.appsigncontrol.application.controller;

import com.projarc.appsigncontrol.application.dto.AssinaturaDto;
import com.projarc.appsigncontrol.domain.model.AplicativoModel;
import com.projarc.appsigncontrol.domain.model.AssinaturaModel;
import com.projarc.appsigncontrol.domain.service.AssinaturaService;
import com.projarc.appsigncontrol.persistence.entity.AssinaturaEntity;

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
@RequestMapping("/api/assinaturas")
public class AssinaturaController {

    @Autowired
    private AssinaturaService assinaturaService;

    public AssinaturaController(AssinaturaService assinaturaService) {
        this.assinaturaService = assinaturaService;
    }

    @GetMapping
    @CrossOrigin(origins = "*")
    public List<AssinaturaDto> getAll() {
        return this.assinaturaService.getAll();
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = "*")
    public AssinaturaDto getById(@PathVariable Long id) {
        return this.assinaturaService.getById(id);
    }

    @GetMapping("/{type}")
    @CrossOrigin(origins = "*")
    public AplicativoModel getByType(@PathVariable String type) {
        return this.assinaturaService.getByType(type);
    }

    @PostMapping
    @CrossOrigin(origins = "*")
    public AssinaturaDto create(@RequestBody AssinaturaDto payload) {
        AssinaturaEntity assinatura = this.assinaturaService.create(payload);
        return AssinaturaEntity.toAssinaturaDto(assinatura);
    }
}