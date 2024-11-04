package com.gestioneviaggi.GestioneViaggiAziendali.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NotNull
    private Viaggio viaggio;

    @ManyToOne
    @NotNull
    private Dipendente dipendente;

    @NotNull
    private LocalDate dataRichiesta;

    private String note;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull Viaggio getViaggio() {
        return viaggio;
    }

    public void setViaggio(@NotNull Viaggio viaggio) {
        this.viaggio = viaggio;
    }

    public @NotNull Dipendente getDipendente() {
        return dipendente;
    }

    public void setDipendente(@NotNull Dipendente dipendente) {
        this.dipendente = dipendente;
    }

    public @NotNull LocalDate getDataRichiesta() {
        return dataRichiesta;
    }

    public void setDataRichiesta(@NotNull LocalDate dataRichiesta) {
        this.dataRichiesta = dataRichiesta;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
