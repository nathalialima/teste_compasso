package com.compassouol.demo.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

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

    @OneToOne
    private City city;

    public Client(String completeName, String gender, LocalDate bornDate, Integer age){
        this.completeName = completeName;
        this.gender = gender;
        this.bornDate = bornDate;
        this.age = age;
    }
}
