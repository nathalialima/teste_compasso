package com.compassouol.demo.services;

import com.compassouol.demo.dtos.CityDto;
import com.compassouol.demo.entities.City;
import com.compassouol.demo.exceptions.CityException;
import com.compassouol.demo.exceptions.CityNotFoundException;
import com.compassouol.demo.repositories.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CityServiceImp implements CityService {

    private final CityRepository cityRepository;

    public City createCity(CityDto cityDto) throws CityException {
        try {
            return cityRepository.save(cityDto.parserToEntity());
        } catch (Exception e) {
            throw new CityException("error save city");
        }
    }

    @Override
    public City findById(UUID uuid) throws CityNotFoundException {
        return cityRepository.findById(uuid).orElseThrow(() -> new CityNotFoundException(uuid));
    }

    @Override
    public List<City> findByName(String name) {
        return cityRepository.findCityByName(name);
    }

    @Override
    public List<City> findByState(String state) {
        return cityRepository.findCityByState(state);
    }
}
