package com.compassouol.demo.services;

import com.compassouol.demo.dtos.CityDto;
import com.compassouol.demo.entities.City;
import com.compassouol.demo.exceptions.CityException;
import com.compassouol.demo.exceptions.CityNotFoundException;

import java.util.List;
import java.util.UUID;

public interface CityService {
    City createCity(CityDto cityDto) throws CityException;

    City findById(UUID uuid) throws CityNotFoundException;

    List<City> findByName(String name);

    List<City> findByState(String state);
}
