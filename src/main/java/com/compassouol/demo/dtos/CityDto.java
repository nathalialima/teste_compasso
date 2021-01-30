package com.compassouol.demo.dtos;


import com.compassouol.demo.entities.City;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Setter
@Getter
public class CityDto {


    @NotBlank(message = "The field not can be blank")
    @NotNull(message = "The field not can be nullable")
    private String name;

    @NotBlank(message = "The field not can be blank")
    @NotNull(message = "The field not can be nullable")
    private String state;

    public City parserToEntity(){
        return new City(name, state);
    }
}
