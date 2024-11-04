package com.gestioneviaggi.GestioneViaggiAziendali.controller;

import com.gestioneviaggi.GestioneViaggiAziendali.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> loginRequest) {
        String email = loginRequest.get("email");
        String password = loginRequest.get("password");
        String token = authenticationService.authenticate(email, password);
        return Map.of("token", token);
    }
}
