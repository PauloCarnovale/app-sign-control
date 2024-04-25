package com.projarc.appsigncontrol.controller;

import com.projarc.appsigncontrol.dto.AplicativoDto;
import com.projarc.appsigncontrol.entity.AplicativoEntity;
import com.projarc.appsigncontrol.model.AplicativoModel;
import com.projarc.appsigncontrol.service.AplicativoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/api/aplicativos")
public class AplicativoController {

    @Autowired
    private AplicativoService aplicativoService;

    public AplicativoController(AplicativoService aplicativoService){
        this.aplicativoService = aplicativoService;
    }

    @GetMapping
    public List<AplicativoModel> getAll() {
        return this.aplicativoService.getAll();
    }

    @GetMapping("/{id}")
    public AplicativoModel getById(@PathVariable Long id) {
        return this.aplicativoService.getById(id);
    }

    @PostMapping
    public AplicativoEntity create(@RequestBody AplicativoDto payload) {
        return this.aplicativoService.create(payload);
    }
}