package com.gestioneviaggi.GestioneViaggiAziendali.controller;

import com.gestioneviaggi.GestioneViaggiAziendali.exception.ResourceNotFoundException;
import com.gestioneviaggi.GestioneViaggiAziendali.model.Dipendente;
import com.gestioneviaggi.GestioneViaggiAziendali.model.dto.DipendenteDTO;
import com.gestioneviaggi.GestioneViaggiAziendali.service.DipendenteService;
import com.gestioneviaggi.GestioneViaggiAziendali.service.FileUploadService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/dipendenti")
public class DipendenteController {

    @Autowired
    private DipendenteService dipendenteService;

    @Autowired
    private FileUploadService fileUploadService;

    @GetMapping
    public List<DipendenteDTO> getAllDipendenti() {
        return dipendenteService.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DipendenteDTO> getDipendenteById(@PathVariable Long id) {
        return dipendenteService.findById(id)
                .map(this::convertToDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<DipendenteDTO> createDipendente(@Valid @RequestBody Dipendente dipendente) {
        Dipendente savedDipendente = dipendenteService.save(dipendente);
        return new ResponseEntity<>(convertToDTO(savedDipendente), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDipendente(@PathVariable Long id) {
        dipendenteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/upload-profile-image")
    public ResponseEntity<String> uploadProfileImage(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
        try {
            String imageUrl = fileUploadService.uploadFile(file, id);
            Dipendente dipendente = dipendenteService.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Dipendente non trovato"));
            dipendente.setImagineProfiloUrl(imageUrl);
            dipendenteService.save(dipendente);
            return ResponseEntity.ok("Immagine caricata con successo: " + imageUrl);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Errore durante il caricamento dell'immagine");
        }
    }

    private DipendenteDTO convertToDTO(Dipendente dipendente) {
        DipendenteDTO dto = new DipendenteDTO();
        dto.setId(dipendente.getId());
        dto.setUsername(dipendente.getUsername());
        dto.setNome(dipendente.getNome());
        dto.setCognome(dipendente.getCognome());
        dto.setEmail(dipendente.getEmail());
        dto.setImagineProfiloUrl(dipendente.getImagineProfiloUrl());
        return dto;
    }
}
