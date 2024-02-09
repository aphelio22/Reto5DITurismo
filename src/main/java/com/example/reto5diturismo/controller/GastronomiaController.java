package com.example.reto5diturismo.controller;

import com.example.reto5diturismo.model.Evento;
import com.example.reto5diturismo.model.Gastronomia;
import com.example.reto5diturismo.repository.EventoRepository;
import com.example.reto5diturismo.repository.GastronomiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/turismo")
public class GastronomiaController {

    @Autowired
    private GastronomiaRepository gastronomiaRepository;

    //Tabla Gastronomia.
    @GetMapping("/gastronomia")
    public List<Gastronomia> getAllGastroPlato() {
        return gastronomiaRepository.findAll();
    }

    @GetMapping("/gastronomia/id/{id}")
    public Gastronomia getGastroPlatobyId(@PathVariable Integer id) {
        return gastronomiaRepository.getGastronomiaById(id);
    }

    @GetMapping("/gastronomia/origen/{origen}")
    public Gastronomia getGastroPlatobyOrigen(@PathVariable String origen) {
        return gastronomiaRepository.getGastronomiaByOrigen(origen);
    }

    @GetMapping("/gatronomia/nombre/{nombre}")
    public Gastronomia getGastroPlatobyNombre(@PathVariable String nombre) {
        return gastronomiaRepository.getGastronomiaByNombre(nombre);
    }
}
