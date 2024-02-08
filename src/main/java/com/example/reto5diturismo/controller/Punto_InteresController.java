package com.example.reto5diturismo.controller;

import com.example.reto5diturismo.model.Museo;
import com.example.reto5diturismo.model.Punto_Interes;
import com.example.reto5diturismo.repository.Punto_InteresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/turismo")
public class Punto_InteresController {

    @Autowired
    private Punto_InteresRepository puntoInteresRepository;

    @GetMapping("/punto_interes")
    public List<Punto_Interes> getAllPuntoInteres() {
        return puntoInteresRepository.findAll();
    }
}
