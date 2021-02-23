package com.etimokhov.clients.repository;

import com.etimokhov.clients.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client> findAllByOrderByLastNameAscFirstNameAscPatronymicAsc();
}
