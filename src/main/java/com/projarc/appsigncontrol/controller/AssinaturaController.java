package com.projarc.appsigncontrol.controller;

import com.projarc.appsigncontrol.dto.AssinaturaDto;
import com.projarc.appsigncontrol.entity.AssinaturaEntity;
import com.projarc.appsigncontrol.model.AssinaturaModel;
import com.projarc.appsigncontrol.service.AssinaturaService;

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
    public List<AssinaturaModel> getAll() {
        return this.assinaturaService.getAll();
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = "*")
    public AssinaturaModel getById(@PathVariable Long id) {
        return this.assinaturaService.getById(id);
    }

    @PostMapping
    @CrossOrigin(origins = "*")
    public AssinaturaEntity create(@RequestBody AssinaturaDto payload) {
        return this.assinaturaService.create(payload);
    }
}