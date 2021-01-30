package com.compassouol.demo.exceptions;

import java.util.UUID;

public class CityNotFoundException extends Exception{
    public CityNotFoundException(UUID uuid){
        super("City with id "+uuid.toString()+" not found");
    }
}
