package com.gestioneviaggi.GestioneViaggiAziendali.controller;

import com.gestioneviaggi.GestioneViaggiAziendali.model.Viaggio;
import com.gestioneviaggi.GestioneViaggiAziendali.service.ViaggioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/viaggi")
public class ViaggioController {

    @Autowired
    private ViaggioService viaggioService;

    @GetMapping
    public ResponseEntity<List<Viaggio>> getAllViaggi() {
        return ResponseEntity.ok(viaggioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Viaggio> getViaggioById(@PathVariable Long id) {
        return viaggioService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Viaggio> createViaggio(@Valid @RequestBody Viaggio viaggio) {
        return new ResponseEntity<>(viaggioService.save(viaggio), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Viaggio> updateStatoViaggio(@PathVariable Long id, @RequestParam Viaggio.StatoViaggio nuovoStato) {
        return ResponseEntity.ok(viaggioService.updateStato(id, nuovoStato));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteViaggio(@PathVariable Long id) {
        viaggioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
