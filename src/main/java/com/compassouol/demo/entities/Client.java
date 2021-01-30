package com.compassouol.demo.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
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

    private String completeName;

    private String gender;

    private Date bornDate;

    private Integer age;

    @OneToOne
    private City city;

    public Client(String completeName, String gender, Date bornDate, Integer age){
        this.completeName = completeName;
        this.gender = gender;
        this.bornDate = bornDate;
        this.age = age;
    }
}
