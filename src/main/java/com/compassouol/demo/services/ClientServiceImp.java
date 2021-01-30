package com.compassouol.demo.services;

import com.compassouol.demo.dtos.ClientDto;
import com.compassouol.demo.entities.City;
import com.compassouol.demo.entities.Client;
import com.compassouol.demo.exceptions.CityNotFoundException;
import com.compassouol.demo.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientServiceImp implements  ClientService{

    private final ClientRepository clientRepository;
    private final CityService cityService;

    @Override
    public Client create(ClientDto clientDto) throws CityNotFoundException {
        City city =  cityService.findById(clientDto.getCityId());
        Client client = clientDto.parserToEntity();
        client.setCity(city);
        return clientRepository.save(client);
    }
}
