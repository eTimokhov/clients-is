package com.etimokhov.clients.service;

import com.etimokhov.clients.exception.NotFoundException;
import com.etimokhov.clients.model.Client;
import com.etimokhov.clients.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getClients() {
        return clientRepository.findAllByOrderByLastNameAscFirstNameAscPatronymicAsc();
    }

    public Client getClient(Long id) {
        return clientRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public Client getEmptyClientStub() {
        return new Client();
    }

    public Long saveClient(Client client) {
        client = clientRepository.save(client);
        return client.getId();
    }
}
