package com.gestioneviaggi.GestioneViaggiAziendali.model.dto;

import java.time.LocalDate;

public class PrenotazioneDTO {
    private Long id;
    private Long viaggioId;
    private Long dipendenteId;
    private LocalDate dataRichiesta;
    private String note;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getViaggioId() {
        return viaggioId;
    }

    public void setViaggioId(Long viaggioId) {
        this.viaggioId = viaggioId;
    }

    public Long getDipendenteId() {
        return dipendenteId;
    }

    public void setDipendenteId(Long dipendenteId) {
        this.dipendenteId = dipendenteId;
    }

    public LocalDate getDataRichiesta() {
        return dataRichiesta;
    }

    public void setDataRichiesta(LocalDate dataRichiesta) {
        this.dataRichiesta = dataRichiesta;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
