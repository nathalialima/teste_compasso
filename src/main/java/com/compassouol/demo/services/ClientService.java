package com.compassouol.demo.services;

import com.compassouol.demo.dtos.ClientDto;
import com.compassouol.demo.entities.Client;
import com.compassouol.demo.exceptions.CityNotFoundException;

public interface ClientService {
    Client create(ClientDto client) throws CityNotFoundException;
}
