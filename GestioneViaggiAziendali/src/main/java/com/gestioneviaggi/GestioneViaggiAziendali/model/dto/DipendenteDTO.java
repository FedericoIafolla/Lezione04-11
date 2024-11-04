package com.gestioneviaggi.GestioneViaggiAziendali.model.dto;

public class DipendenteDTO {
    private Long id;
    private String username;
    private String nome;
    private String cognome;
    private String email;
    private String imagineProfiloUrl;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImagineProfiloUrl() {
        return imagineProfiloUrl;
    }

    public void setImagineProfiloUrl(String imagineProfiloUrl) {
        this.imagineProfiloUrl = imagineProfiloUrl;
    }
}
