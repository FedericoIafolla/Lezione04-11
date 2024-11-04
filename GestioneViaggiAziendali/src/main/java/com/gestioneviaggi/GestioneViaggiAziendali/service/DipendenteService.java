package com.gestioneviaggi.GestioneViaggiAziendali.service;

import com.gestioneviaggi.GestioneViaggiAziendali.exception.CustomException;
import com.gestioneviaggi.GestioneViaggiAziendali.model.Dipendente;
import com.gestioneviaggi.GestioneViaggiAziendali.repository.DipendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DipendenteService {

    @Autowired
    private DipendenteRepository dipendenteRepository;

    public List<Dipendente> findAll() {
        return dipendenteRepository.findAll();
    }

    public Optional<Dipendente> findById(Long id) {
        return dipendenteRepository.findById(id);
    }

    public Dipendente save(Dipendente dipendente) {
        return dipendenteRepository.save(dipendente);
    }

    public void deleteById(Long id) {
        if (!dipendenteRepository.existsById(id)) {
            throw new CustomException("Dipendente non trovato");
        }
        dipendenteRepository.deleteById(id);
    }
}
