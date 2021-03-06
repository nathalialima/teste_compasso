package com.compassouol.demo.dtos;

import com.compassouol.demo.entities.Client;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

@Setter
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

    public Client parserToEntity() {
        return new Client(completeName, gender, bornDate, age);
    }

}
