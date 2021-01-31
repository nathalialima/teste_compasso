package com.compassouol.demo.exceptions;

import java.util.UUID;

public class ClientNotFoundException extends Exception {
    public ClientNotFoundException(UUID uuid) {
        super("Client with id " + uuid.toString() + " not found");
    }
}
