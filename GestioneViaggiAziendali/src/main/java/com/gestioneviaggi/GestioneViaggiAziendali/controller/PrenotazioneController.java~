package com.gestioneviaggi.GestioneViaggiAziendali.controller;

import com.gestioneviaggi.GestioneViaggiAziendali.model.Prenotazione;
import com.gestioneviaggi.GestioneViaggiAziendali.service.PrenotazioneService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prenotazioni")
public class PrenotazioneController {

    @Autowired
    private PrenotazioneService prenotazioneService;

    @GetMapping
    public List<Prenotazione> getAllPrenotazioni() {
        return prenotazioneService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prenotazione> getPrenotazioneById(@PathVariable Long id) {
        return prenotazioneService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Prenotazione> createPrenotazione(@Valid @RequestBody Prenotazione prenotazione) {
        return new ResponseEntity<>(prenotazioneService.save(prenotazione), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrenotazione(@PathVariable Long id) {
        prenotazioneService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
