package com.clientsup.sgc.dto;


import com.clientsup.sgc.entity.Client;

import java.time.LocalDate;
import java.util.Objects;

public class ClientDTO {

    private Long id;
    private String name;
    private String cpf;
    private Double incoming;
    private LocalDate birthDate;
    private Integer children;

    public ClientDTO(Client client){
        this.id = client.getId();
        this.name = client.getName();
        this.cpf = client.getCpf();
        this.incoming = client.getIncoming();
        this.birthDate = client.getBirthDate();
        this.children = client.getChildren();
    }

    public ClientDTO(Long id, String name, String cpf, Double incoming, LocalDate birthDate, Integer children) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.incoming = incoming;
        this.birthDate = birthDate;
        this.children = children;
    }

    public ClientDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Double getIncoming() {
        return incoming;
    }

    public void setIncoming(Double incoming) {
        this.incoming = incoming;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getChildren() {
        return children;
    }

    public void setChildren(Integer children) {
        this.children = children;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientDTO clientDTO = (ClientDTO) o;

        return Objects.equals(id, clientDTO.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
