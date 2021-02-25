package com.etimokhov.clients.service;

import com.etimokhov.clients.exception.NotFoundException;
import com.etimokhov.clients.model.Citizenship;
import com.etimokhov.clients.model.City;
import com.etimokhov.clients.model.Client;
import com.etimokhov.clients.model.Disability;
import com.etimokhov.clients.model.MaritalStatus;
import com.etimokhov.clients.repository.CitizenshipRepository;
import com.etimokhov.clients.repository.CityRepository;
import com.etimokhov.clients.repository.ClientRepository;
import com.etimokhov.clients.repository.DisabilityRepository;
import com.etimokhov.clients.repository.MaritalStatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class ClientService {
    private final ClientRepository clientRepository;
    private final CitizenshipRepository citizenshipRepository;
    private final CityRepository cityRepository;
    private final DisabilityRepository disabilityRepository;
    private final MaritalStatusRepository maritalStatusRepository;

    public ClientService(ClientRepository clientRepository, CitizenshipRepository citizenshipRepository, CityRepository cityRepository, DisabilityRepository disabilityRepository, MaritalStatusRepository maritalStatusRepository) {
        this.clientRepository = clientRepository;
        this.citizenshipRepository = citizenshipRepository;
        this.cityRepository = cityRepository;
        this.disabilityRepository = disabilityRepository;
        this.maritalStatusRepository = maritalStatusRepository;
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

    public Map<String, List> getDictionary() {
        return Map.of(
                "cityOptions", cityRepository.findAll(),
                "citizenshipOptions", citizenshipRepository.findAll(),
                "disabilityOptions", disabilityRepository.findAll(),
                "maritalStatusOptions", maritalStatusRepository.findAll()
        );
    }

    public void deleteClient(Long clientId) {
        clientRepository.deleteById(clientId);
    }

    public boolean isPassportDuplicated(Client client) {
        return clientRepository.findAll().stream()
                .filter(c -> c.getId() != client.getId())
                .map(c -> c.getPassportSeries() + c.getPassportNumber())
                .anyMatch(passport -> passport.equals(client.getPassportSeries() + client.getPassportNumber()));
    }

    public boolean isPassportIdDuplicated(Client client) {
        return clientRepository.findAll().stream()
                .filter(c -> c.getId() != client.getId())
                .map(c -> c.getPassportID())
                .anyMatch(passportId -> passportId.equals(client.getPassportID()));
    }
}
