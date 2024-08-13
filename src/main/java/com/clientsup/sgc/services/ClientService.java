package com.clientsup.sgc.services;

import com.clientsup.sgc.dto.ClientDTO;
import com.clientsup.sgc.entity.Client;
import com.clientsup.sgc.repositories.ClientRepository;
import com.clientsup.sgc.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository repository;
    public ClientDTO getById(Long id) {
        Client entity = repository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Cliente com id: "+id+" não encontrado"));
        ClientDTO dto = new ClientDTO(entity);
        return dto;
    }

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable) {
        Page<Client> pageClientEntity = repository.findAll(pageable);
        return pageClientEntity.map(x->new ClientDTO(x));
    }
}
