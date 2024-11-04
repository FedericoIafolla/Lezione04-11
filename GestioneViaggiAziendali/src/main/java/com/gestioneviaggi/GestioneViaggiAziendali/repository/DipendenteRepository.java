package com.gestioneviaggi.GestioneViaggiAziendali.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gestioneviaggi.GestioneViaggiAziendali.model.Dipendente;

import java.util.Optional;

public interface DipendenteRepository extends JpaRepository<Dipendente, Long> {
    Optional<Dipendente> findByEmail(String email);
}
