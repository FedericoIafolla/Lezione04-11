package com.gestioneviaggi.GestioneViaggiAziendali.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
