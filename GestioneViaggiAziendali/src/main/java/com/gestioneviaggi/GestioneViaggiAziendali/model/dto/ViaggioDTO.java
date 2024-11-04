package com.gestioneviaggi.GestioneViaggiAziendali.model.dto;

import com.gestioneviaggi.GestioneViaggiAziendali.model.Viaggio;

import java.time.LocalDate;

public class ViaggioDTO {
    private Long id;
    private String destinazione;
    private LocalDate data;
    private Viaggio.StatoViaggio stato;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDestinazione() {
        return destinazione;
    }

    public void setDestinazione(String destinazione) {
        this.destinazione = destinazione;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Viaggio.StatoViaggio getStato() {
        return stato;
    }

    public void setStato(Viaggio.StatoViaggio stato) {
        this.stato = stato;
    }
}
