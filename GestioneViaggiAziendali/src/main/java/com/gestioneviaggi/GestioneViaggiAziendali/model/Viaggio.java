package com.gestioneviaggi.GestioneViaggiAziendali.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;


@Entity
public class Viaggio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String destinazione;

    @NotNull
    private LocalDate data;

    @Enumerated(EnumType.STRING)
    private StatoViaggio stato;

    public enum StatoViaggio {
        IN_PROGRAMMA,
        COMPLETATO
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank String getDestinazione() {
        return destinazione;
    }

    public void setDestinazione(@NotBlank String destinazione) {
        this.destinazione = destinazione;
    }

    public @NotNull LocalDate getData() {
        return data;
    }

    public void setData(@NotNull LocalDate data) {
        this.data = data;
    }

    public StatoViaggio getStato() {
        return stato;
    }

    public void setStato(StatoViaggio stato) {
        this.stato = stato;
    }
}
