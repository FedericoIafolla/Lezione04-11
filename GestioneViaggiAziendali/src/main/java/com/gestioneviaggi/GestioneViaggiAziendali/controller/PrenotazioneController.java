package com.gestioneviaggi.GestioneViaggiAziendali.controller;

import com.gestioneviaggi.GestioneViaggiAziendali.model.Prenotazione;
import com.gestioneviaggi.GestioneViaggiAziendali.model.dto.PrenotazioneDTO;
import com.gestioneviaggi.GestioneViaggiAziendali.service.PrenotazioneService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/prenotazioni")
public class PrenotazioneController {

    @Autowired
    private PrenotazioneService prenotazioneService;

    @GetMapping
    public List<PrenotazioneDTO> getAllPrenotazioni() {
        return prenotazioneService.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrenotazioneDTO> getPrenotazioneById(@PathVariable Long id) {
        return prenotazioneService.findById(id)
                .map(this::convertToDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PrenotazioneDTO> createPrenotazione(@Valid @RequestBody Prenotazione prenotazione) {
        Prenotazione savedPrenotazione = prenotazioneService.save(prenotazione);
        return new ResponseEntity<>(convertToDTO(savedPrenotazione), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrenotazione(@PathVariable Long id) {
        prenotazioneService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    private PrenotazioneDTO convertToDTO(Prenotazione prenotazione) {
        PrenotazioneDTO dto = new PrenotazioneDTO();
        dto.setId(prenotazione.getId());
        dto.setViaggioId(prenotazione.getViaggio().getId());
        dto.setDipendenteId(prenotazione.getDipendente().getId());
        dto.setDataRichiesta(prenotazione.getDataRichiesta());
        dto.setNote(prenotazione.getNote());
        return dto;
    }
}
