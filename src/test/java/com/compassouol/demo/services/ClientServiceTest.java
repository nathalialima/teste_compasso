package com.compassouol.demo.services;

import com.compassouol.demo.dtos.ClientDto;
import com.compassouol.demo.entities.City;
import com.compassouol.demo.entities.Client;
import com.compassouol.demo.exceptions.CityNotFoundException;
import com.compassouol.demo.exceptions.ClientException;
import com.compassouol.demo.exceptions.ClientNotFoundException;
import com.compassouol.demo.repositories.CityRepository;
import com.compassouol.demo.repositories.ClientRepository;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.PersistenceException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.*;
import static org.springframework.test.util.AssertionErrors.assertEquals;

public class ClientServiceTest {
    private final ClientRepository clientRepository = mock(ClientRepository.class);
    private final CityRepository cityRepository = mock(CityRepository.class);
    private final CityService cityService = mock(CityService.class);
    private final ClientService clientService = new ClientServiceImp(clientRepository, cityService);

    private Client client;
    private ClientDto clientDto;
    private City city;

    @BeforeEach
    void init() {
        LocalDate date = LocalDate.now();
        city = new City("Teste", "Teste");
        client = new Client("teste", "teste", date, 1);
        client.setCity(city);
        client.setCompleteName("teste");
        client.setGender("teste");

        clientDto = new ClientDto();
        clientDto.setAge(1);
        clientDto.setBornDate(date);
        clientDto.setCompleteName("teste");
        clientDto.setGender("teste");
        clientDto.setCityId(UUID.fromString("04fadd08-ba7d-4bd0-a8c4-2ce9608b9741"));

    }

    @SneakyThrows
    @Test
    void create() {
        UUID uuidCity = UUID.fromString("04fadd08-ba7d-4bd0-a8c4-2ce9608b9741");
        when(cityService.findById(uuidCity)).thenReturn(city);
        when(clientRepository.save(client)).thenReturn(client);
        Client clientTest = clientService.create(clientDto);
        verify(clientRepository, times(1)).save(client);
        verify(cityService, times(1)).findById(uuidCity);
        assertEquals("equals", clientTest.getCompleteName(), clientDto.getCompleteName());
    }


    @SneakyThrows
    @Test
    void createClientCityNotFoundException() {
        UUID uuidCity = UUID.fromString("04fadd08-ba7d-4bd0-a8c4-2ce9608b9741");
        when(cityService.findById(uuidCity)).thenThrow(CityNotFoundException.class);
        Assertions.assertThrows(CityNotFoundException.class, () -> clientService.create(clientDto));
    }

    @Test
    void createClientException() throws CityNotFoundException {
        UUID uuidCity = UUID.fromString("04fadd08-ba7d-4bd0-a8c4-2ce9608b9741");
        when(cityService.findById(uuidCity)).thenReturn(city);
        when(clientRepository.save(client)).thenThrow(PersistenceException.class);
        Assertions.assertThrows(ClientException.class, () -> clientService.create(clientDto));
    }

    @SneakyThrows
    @Test
    void findById() {
        UUID uuid = UUID.randomUUID();
        Optional<Client> clientOptionalTest = Optional.of(client);
        when(clientRepository.findById(uuid)).thenReturn(clientOptionalTest);
        Client clientTest = clientService.findById(uuid);
        verify(clientRepository, times(1)).findById(uuid);
        assertEquals("equals", clientTest.getCompleteName(), "teste");
    }

    @Test
    void findByName() {
        String name = "teste";
        when(clientRepository.findClientByCompleteNameContains(name)).thenReturn(Collections.singletonList(client));
        List<Client> clients = clientService.findByName(name);
        verify(clientRepository, times(1)).findClientByCompleteNameContains(name);
        assertEquals("equals", clients.size(), 1);
    }

    @SneakyThrows
    @Test
    void deleteById() {
        UUID uuid = UUID.randomUUID();
        Optional<Client> clientOptionalTest = Optional.of(client);
        when(clientRepository.findById(uuid)).thenReturn(clientOptionalTest);
        clientService.deleteById(uuid);
        verify(clientRepository, times(1)).delete(any());
    }

    @Test
    void deleteByIdException() {
        UUID uuid = UUID.randomUUID();
        Assertions.assertThrows(ClientNotFoundException.class, () -> clientService.deleteById(uuid));
    }

    @SneakyThrows
    @Test
    void updateNameById() {
        UUID uuid = UUID.randomUUID();
        Optional<Client> clientOptionalTest = Optional.of(client);
        String name = "Teste2";
        client.setCompleteName(name);
        when(clientRepository.findById(uuid)).thenReturn(clientOptionalTest);
        when(clientRepository.save(client)).thenReturn(client);
        Client clientTest = clientService.updateNameById(uuid, name);
        verify(clientRepository, times(1)).findById(uuid);
        verify(clientRepository, times(1)).save(client);
        assertEquals("equals", clientTest.getCompleteName(), name);
    }

    @Test
    void updateNameByIdClientNotFoundException() {
        UUID uuid = UUID.randomUUID();
        String name = "Teste2";
        Assertions.assertThrows(ClientNotFoundException.class, () -> clientService.updateNameById(uuid, name));
    }

    @Test
    void updateNameByIdClientException() {
        UUID uuid = UUID.randomUUID();
        Optional<Client> clientOptionalTest = Optional.of(client);
        String name = "Teste2";
        client.setCompleteName(name);
        when(clientRepository.findById(uuid)).thenReturn(clientOptionalTest);
        when(clientRepository.save(client)).thenThrow(PersistenceException.class);
        Assertions.assertThrows(ClientException.class, () -> clientService.updateNameById(uuid, name));
    }
}
