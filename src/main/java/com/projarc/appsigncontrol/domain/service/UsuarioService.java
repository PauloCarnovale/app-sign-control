package com.projarc.appsigncontrol.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.projarc.appsigncontrol.application.dto.UsuarioDto;
import com.projarc.appsigncontrol.persistence.entity.UsuarioEntity;
import com.projarc.appsigncontrol.persistence.repository.UsuarioRepositoryJPA;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepositoryJPA usuarioRepository;

    public UsuarioService(UsuarioRepositoryJPA usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    private UsuarioEntity getUsuarioByLogin(String login) {
        List<UsuarioEntity> usuarios = this.usuarioRepository.getAll();
        List<UsuarioEntity> filteredUsuarios = usuarios.stream()
                .filter(usuario -> usuario.getUsuario().equals(login))
                .collect(Collectors.toList());
        // Campo login é unique, logo só poderá haver no maximo 1 registro
        if (filteredUsuarios.size() == 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Credenciais incorretas");
        }
        return filteredUsuarios.get(0);
    }

    public UsuarioEntity validateUsuario(UsuarioDto payload) {
        UsuarioEntity usuario = this.getUsuarioByLogin(payload.getUsuario());

        if (usuario.getSenha().equals(payload.getSenha())) {
            return usuario;
        }

        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Credenciais incorretas");
    }

    public UsuarioEntity saveUsuario(UsuarioDto payload) {
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setSenha(payload.getSenha());
        usuarioEntity.setUsuario(payload.getUsuario());
        return this.usuarioRepository.save(usuarioEntity);
    }

    public boolean deleteUsuario(UsuarioDto payload) {
        UsuarioEntity usuario = this.getUsuarioByLogin(payload.getUsuario());

        System.out.println(usuario.getId());
        if (payload.getSenha().equals(usuario.getSenha())) {
            System.out.println(true);
            return this.usuarioRepository.delete(usuario);
        }

        return false;
    }
}
