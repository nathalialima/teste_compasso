package com.compassouol.demo.services;

import com.compassouol.demo.dtos.ClientDto;
import com.compassouol.demo.entities.City;
import com.compassouol.demo.entities.Client;
import com.compassouol.demo.exceptions.CityNotFoundException;
import com.compassouol.demo.exceptions.ClientException;
import com.compassouol.demo.exceptions.ClientNotFoundException;
import com.compassouol.demo.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClientServiceImp implements ClientService {

    private final ClientRepository clientRepository;
    private final CityService cityService;

    @Override
    public Client create(ClientDto clientDto) throws CityNotFoundException, ClientException {
        City city = cityService.findById(clientDto.getCityId());
        try {
            Client client = clientDto.parserToEntity();
            client.setCity(city);
            return clientRepository.save(client);
        } catch (Exception e) {
            throw new ClientException("error save client");
        }

    }

    @Override
    public Client findById(UUID uuid) throws ClientNotFoundException {
        return clientRepository.findById(uuid).orElseThrow(() -> new ClientNotFoundException(uuid));
    }

    @Override
    public List<Client> findByName(String name) {
        return clientRepository.findClientByCompleteNameContains(name);
    }

    @Override
    public void deleteById(UUID uuid) throws ClientNotFoundException {
        Client client = findById(uuid);
        clientRepository.delete(client);
    }

    @Override
    public Client updateNameById(UUID uuid, String name) throws ClientNotFoundException, ClientException {
        Client client = findById(uuid);
        client.setCompleteName(name);
        try {
            return clientRepository.save(client);
        } catch (Exception e) {
            throw new ClientException("error save client");
        }
    }
}
