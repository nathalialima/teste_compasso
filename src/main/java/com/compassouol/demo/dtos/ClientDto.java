package com.compassouol.demo.dtos;

import com.compassouol.demo.entities.Client;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.time.LocalDate;
import java.util.UUID;

@Getter
public class ClientDto {

    @NotBlank(message = "The field not can be blank")
    @NotNull(message = "The field not can be nullable")
    private String completeName;

    @NotBlank(message = "The field not can be blank")
    @NotNull(message = "The field not can be nullable")
    private String gender;

    @NotNull(message = "The field not can be nullable")
    private LocalDate bornDate;

    @Min(value = 0, message = "The field must be greater than 0")
    private Integer age;

    @NotNull(message = "The field not can be nullable")
    private UUID cityId;

    public Client parserToEntity(){
        return  new Client(completeName, gender, bornDate, age);
    }

}
