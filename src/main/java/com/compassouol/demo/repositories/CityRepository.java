package com.compassouol.demo.repositories;

import com.compassouol.demo.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CityRepository extends JpaRepository<City, UUID> {
    List<City> findCityByName(String name);

    List<City> findCityByState(String state);
}
