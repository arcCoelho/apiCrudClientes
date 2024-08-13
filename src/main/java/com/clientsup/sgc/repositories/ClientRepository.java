package com.clientsup.sgc.repositories;

import com.clientsup.sgc.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
