package com.gestioneviaggi.GestioneViaggiAziendali.config;

import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
public class CloudinaryConfig {

    @Bean
    public Cloudinary cloudinary() {
        HashMap<String, String> config = new HashMap<>();
        config.put("cloud_name", "dtuwqnrfm");
        config.put("api_key", "737999241767736");
        config.put("api_secret", "kTwzdWxNKj_ByMhg6-3tVGsKF3I");
        return new Cloudinary(config);
    }
}
