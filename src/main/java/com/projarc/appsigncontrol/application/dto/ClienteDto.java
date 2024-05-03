package com.projarc.appsigncontrol.application.dto;

public class ClienteDto {
    private long id;
    private String name;
    private String email;

    public ClienteDto(long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }
}
