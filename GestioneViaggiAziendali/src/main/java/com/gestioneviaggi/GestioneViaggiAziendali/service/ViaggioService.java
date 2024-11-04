package com.gestioneviaggi.GestioneViaggiAziendali.service;

import com.gestioneviaggi.GestioneViaggiAziendali.model.Viaggio;
import com.gestioneviaggi.GestioneViaggiAziendali.repository.ViaggioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ViaggioService {

    @Autowired
    private ViaggioRepository viaggioRepository;

    public Page<Viaggio> findAll(Pageable pageable) {
        return viaggioRepository.findAll(pageable);
    }

    public Optional<Viaggio> findById(Long id) {
        return viaggioRepository.findById(id);
    }

    public Viaggio save(Viaggio viaggio) {
        return viaggioRepository.save(viaggio);
    }

    public void deleteById(Long id) {
        viaggioRepository.deleteById(id);
    }

    public Viaggio updateStato(Long id, Viaggio.StatoViaggio nuovoStato) {
        Viaggio viaggio = viaggioRepository.findById(id).orElseThrow();
        viaggio.setStato(nuovoStato);
        return viaggioRepository.save(viaggio);
    }
}
