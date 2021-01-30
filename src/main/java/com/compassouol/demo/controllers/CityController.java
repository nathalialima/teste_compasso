package com.compassouol.demo.controllers;

import com.compassouol.demo.dtos.CityDto;
import com.compassouol.demo.dtos.CityDtoSearch;
import com.compassouol.demo.entities.City;
import com.compassouol.demo.exceptions.CityException;
import com.compassouol.demo.exceptions.CityNotFoundException;
import com.compassouol.demo.services.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/city")
@RequiredArgsConstructor
public class CityController {

    private final CityService cityService;

    @Validated
    @PostMapping("/create")
    public City createCity(@Valid @RequestBody CityDto cityDto) throws CityException {
        return cityService.createCity(cityDto);
    }

    @GetMapping("/id/{id}")
    public City getByCitiesId(@PathVariable("id") UUID uuid) throws CityNotFoundException {
        return cityService.findById(uuid);
    }

    @PostMapping("/name")
    public List<City> getByCitiesName(@RequestBody CityDtoSearch cityDtoSearch) throws CityNotFoundException {
        return cityService.findByName(cityDtoSearch.getName());
    }

    @PostMapping("/state/{state}")
    public List<City> getByCitiesState(@RequestBody CityDtoSearch cityDtoSearch) throws CityNotFoundException {
        return cityService.findByState(cityDtoSearch.getState());
    }

}
