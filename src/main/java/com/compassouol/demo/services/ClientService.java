package com.compassouol.demo.services;

import com.compassouol.demo.dtos.ClientDto;
import com.compassouol.demo.entities.Client;
import com.compassouol.demo.exceptions.CityNotFoundException;
import com.compassouol.demo.exceptions.ClientNotFoundException;

import java.util.List;
import java.util.UUID;

public interface ClientService {
    Client create(ClientDto client) throws CityNotFoundException;
    Client findById(UUID uuid) throws ClientNotFoundException;
    List<Client> findByName(String name);
    void deleteById(UUID uuid) throws ClientNotFoundException;
    Client updateNameById(UUID uuid, String name) throws ClientNotFoundException;
}
