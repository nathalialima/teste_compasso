package com.compassouol.demo.dtos;

import com.compassouol.demo.entities.Client;
import lombok.Getter;

import java.sql.Date;
import java.util.UUID;

@Getter
public class ClientDto {

    private String completeName;

    private String gender;

    private Date bornDate;

    private Integer age;

    private UUID cityId;

    public Client parserToEntity(){
        return  new Client(completeName, gender, bornDate, age);
    }

}
