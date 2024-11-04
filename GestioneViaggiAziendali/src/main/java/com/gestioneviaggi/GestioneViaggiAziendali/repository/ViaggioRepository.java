package com.gestioneviaggi.GestioneViaggiAziendali.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gestioneviaggi.GestioneViaggiAziendali.model.Viaggio;


public interface ViaggioRepository extends JpaRepository<Viaggio, Long> {

}
