package com.gestioneviaggi.GestioneViaggiAziendali.controller;

import com.gestioneviaggi.GestioneViaggiAziendali.model.Viaggio;
import com.gestioneviaggi.GestioneViaggiAziendali.model.dto.ViaggioDTO;
import com.gestioneviaggi.GestioneViaggiAziendali.service.ViaggioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/viaggi")
public class ViaggioController {

    @Autowired
    private ViaggioService viaggioService;

    @GetMapping
    public ResponseEntity<List<ViaggioDTO>> getAllViaggi(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        Page<Viaggio> viaggi = viaggioService.findAll(PageRequest.of(page, size));
        List<ViaggioDTO> viaggiDTO = viaggi.stream().map(this::convertToDTO).collect(Collectors.toList());
        return ResponseEntity.ok(viaggiDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ViaggioDTO> getViaggioById(@PathVariable Long id) {
        return viaggioService.findById(id)
                .map(this::convertToDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ViaggioDTO> createViaggio(@Valid @RequestBody Viaggio viaggio) {
        Viaggio savedViaggio = viaggioService.save(viaggio);
        return new ResponseEntity<>(convertToDTO(savedViaggio), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ViaggioDTO> updateStatoViaggio(@PathVariable Long id, @RequestParam Viaggio.StatoViaggio nuovoStato) {
        return ResponseEntity.ok(convertToDTO(viaggioService.updateStato(id, nuovoStato)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteViaggio(@PathVariable Long id) {
        viaggioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    private ViaggioDTO convertToDTO(Viaggio viaggio) {
        ViaggioDTO dto = new ViaggioDTO();
        dto.setId(viaggio.getId());
        dto.setDestinazione(viaggio.getDestinazione());
        dto.setData(viaggio.getData());
        dto.setStato(viaggio.getStato());
        return dto;
    }
}
