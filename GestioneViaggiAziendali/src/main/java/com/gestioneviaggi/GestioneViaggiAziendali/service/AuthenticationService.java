package com.gestioneviaggi.GestioneViaggiAziendali.service;

import com.gestioneviaggi.GestioneViaggiAziendali.model.Dipendente;
import com.gestioneviaggi.GestioneViaggiAziendali.repository.DipendenteRepository;
import com.gestioneviaggi.GestioneViaggiAziendali.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired
    private DipendenteRepository dipendenteRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String authenticate(String email, String password) {
        Dipendente dipendente = dipendenteRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Utente non trovato"));
        if (passwordEncoder.matches(password, dipendente.getPassword())) {
            return jwtUtil.generateToken(email);
        } else {
            throw new RuntimeException("Credenziali non valide");
        }
    }
}
