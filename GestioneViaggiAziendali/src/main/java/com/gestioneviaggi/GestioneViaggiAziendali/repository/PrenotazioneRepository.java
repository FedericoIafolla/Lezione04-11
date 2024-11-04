package com.gestioneviaggi.GestioneViaggiAziendali.repository;

import com.gestioneviaggi.GestioneViaggiAziendali.model.Dipendente;
import com.gestioneviaggi.GestioneViaggiAziendali.model.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
    boolean existsByDipendenteAndDataRichiesta(Dipendente dipendente, LocalDate dataRichiesta);
}
