package com.compassouol.demo.controllers;

import com.compassouol.demo.dtos.ClientDto;
import com.compassouol.demo.dtos.ClientSearchDto;
import com.compassouol.demo.dtos.ClientUpdateDto;
import com.compassouol.demo.entities.Client;
import com.compassouol.demo.exceptions.CityNotFoundException;
import com.compassouol.demo.exceptions.ClientException;
import com.compassouol.demo.exceptions.ClientNotFoundException;
import com.compassouol.demo.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping("/create")
    public Client createClient(@Valid @RequestBody ClientDto clientDto) throws CityNotFoundException, ClientException {
        return clientService.create(clientDto);
    }

    @GetMapping("/id/{id}")
    public Client getByClientsId(@PathVariable("id") UUID uuid) throws ClientNotFoundException {
        return clientService.findById(uuid);
    }

    @PostMapping("/name")
    public List<Client> getByClientsName(@RequestBody ClientSearchDto clientSearchDto) {
        return clientService.findByName(clientSearchDto.getName());
    }

    @DeleteMapping("/remove/{id}")
    public void removeClientById(@PathVariable("id") UUID uuid) throws ClientNotFoundException {
        clientService.deleteById(uuid);
    }

    @PutMapping("/update/{id}")
    public Client updateClientNameById(@PathVariable("id") UUID uuid, @RequestBody ClientUpdateDto clientUpdateDto) throws ClientNotFoundException, ClientException {
        return clientService.updateNameById(uuid, clientUpdateDto.getName());
    }
}
