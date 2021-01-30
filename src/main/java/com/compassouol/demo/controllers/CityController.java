package com.compassouol.demo.controllers;

import com.compassouol.demo.dtos.CityDto;
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

    @GetMapping("/name/{name}")
    public List<City> getByCitiesName(@PathVariable("name") String name) throws CityNotFoundException {
        return cityService.findByName(name);
    }

    @GetMapping("/state/{state}")
    public List<City> getByCitiesState(@PathVariable("state") String state) throws CityNotFoundException {
        return cityService.findByState(state);
    }

}
