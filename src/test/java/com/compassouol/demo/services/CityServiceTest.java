package com.compassouol.demo.services;


import com.compassouol.demo.dtos.CityDto;
import com.compassouol.demo.entities.City;
import com.compassouol.demo.entities.Client;
import com.compassouol.demo.exceptions.CityException;
import com.compassouol.demo.exceptions.CityNotFoundException;
import com.compassouol.demo.repositories.CityRepository;
import jdk.nashorn.internal.runtime.options.Option;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.PersistenceException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.*;
import static  org.springframework.test.util.AssertionErrors.*;

public class CityServiceTest {

    private  final CityRepository cityRepository = mock(CityRepository.class);

    private final CityService cityService = new CityServiceImp(cityRepository);

    private CityDto cityDto;
    private City city;
    @BeforeEach
    void init(){
        city = new City("Teste","Teste");
        cityDto = new CityDto();
        cityDto.setName("Teste");
        cityDto.setState("Teste");
    }

    @SneakyThrows
    @Test
    void createCity(){
        when(cityRepository.save(city)).thenReturn(city);
        City cityTeste = cityService.createCity(cityDto);
        assertEquals("equals create", cityTeste.getName(), cityDto.getName());
    }

    @Test
    void createCityException(){
        when(cityRepository.save(city)).thenThrow(PersistenceException.class);
        Assertions.assertThrows(CityException.class, () -> cityService.createCity(cityDto));
    }

    @Test
    void findCityException(){
        UUID uuid = UUID.randomUUID();
        Assertions.assertThrows(CityNotFoundException.class, () -> cityService.findById(uuid));
    }

    @Test
    void findById(){
        UUID uuid = UUID.randomUUID();
        Optional<City> cityTest = Optional.of(city);
        when(cityRepository.findById(uuid)).thenReturn(cityTest);
        assertNotNull("optional city", cityTest.get());
        assertEquals("equals field", cityTest.get().getName(),"Teste");
    }

    @Test
    void findByName(){
        when(cityRepository.findCityByName("teste")).thenReturn(Collections.singletonList(city));
        List<City> cities = cityService.findByName("teste");
        verify(cityRepository, times(1)).findCityByName("teste");
        assertEquals("Size of city list",cities.size(), 1);
    }

    @Test
    void findByState(){
        when(cityRepository.findCityByState("Teste")).thenReturn(Collections.singletonList(city));
        List<City> cities = cityService.findByState("Teste");
        verify(cityRepository, times(0)).findCityByName("Teste");
        verify(cityRepository, times(1)).findCityByState("Teste");
        assertEquals("Size of city list",cities.size(), 1);
        assertNotEquals("Size of city list",cities.size(), 2);

    }
}
