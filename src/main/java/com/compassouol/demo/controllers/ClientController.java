package com.compassouol.demo.controllers;

import com.compassouol.demo.dtos.CityDto;
import com.compassouol.demo.dtos.ClientDto;
import com.compassouol.demo.entities.City;
import com.compassouol.demo.entities.Client;
import com.compassouol.demo.exceptions.CityException;
import com.compassouol.demo.exceptions.CityNotFoundException;
import com.compassouol.demo.services.CityService;
import com.compassouol.demo.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping("/create")
    public Client createClient(@Valid @RequestBody ClientDto clientDto) throws CityNotFoundException {
        return clientService.create(clientDto);
    }
}
