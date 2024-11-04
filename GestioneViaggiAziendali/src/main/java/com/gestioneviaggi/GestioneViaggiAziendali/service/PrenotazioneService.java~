package com.gestioneviaggi.GestioneViaggiAziendali.service;

import com.gestioneviaggi.GestioneViaggiAziendali.model.Dipendente;
import com.gestioneviaggi.GestioneViaggiAziendali.model.Prenotazione;
import com.gestioneviaggi.GestioneViaggiAziendali.repository.PrenotazioneRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    public List<Prenotazione> findAll() {
        return prenotazioneRepository.findAll();
    }

    public Optional<Prenotazione> findById(Long id) {
        return prenotazioneRepository.findById(id);
    }

    public Prenotazione save(Prenotazione prenotazione) {
        Dipendente dipendente = prenotazione.getDipendente();
        LocalDate dataRichiesta = prenotazione.getDataRichiesta();

        if (prenotazioneRepository.existsByDipendenteAndDataRichiesta(dipendente, dataRichiesta)) {
            throw new ValidationException("Il dipendente ha già una prenotazione per questa data.");
        }

        return prenotazioneRepository.save(prenotazione);
    }

    public void deleteById(Long id) {
        prenotazioneRepository.deleteById(id);
    }
}
