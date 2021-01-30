package com.compassouol.demo.repositories;

import com.compassouol.demo.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientRepository  extends JpaRepository<Client, UUID> {
}
