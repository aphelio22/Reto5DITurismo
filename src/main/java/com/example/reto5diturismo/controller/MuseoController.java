package com.example.reto5diturismo.controller;

import com.example.reto5diturismo.enums.Descuento;
import com.example.reto5diturismo.model.Gastronomia;
import com.example.reto5diturismo.model.Museo;
import com.example.reto5diturismo.repository.MuseoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/turismo")
public class MuseoController {

    @Autowired
    private MuseoRepository museoRepository;

    //Tabla Museo.
    @GetMapping("/museo")
    public List<Museo> getAllMuseos() {
        return museoRepository.findAll();
    }

    @GetMapping("/museo/id/{id}")
    public Museo getMuseobyId(@PathVariable Integer id) {
        return museoRepository.getMuseoById(id);
    }

    @GetMapping("/museo/nombre/{nombre}")
    public Museo getMuseobyNombre(@PathVariable String nombre) {
        return museoRepository.getMuseoByNombre(nombre);
    }

    @GetMapping("/museo/precio/{precio}")
    public List<Museo> getMuseobyPrecio(@PathVariable Double precio) {
        return museoRepository.getMuseoByPrecioBefore(precio);
    }

    @GetMapping("/museo/tematica/{tematica}")
    public List<Museo> getMuseobyTematica(@PathVariable String tematica) {
        return museoRepository.getMuseoByTematica(tematica);
    }

    @GetMapping("/museo/descuento/{descuento}")
    public List<Museo> getMuseobyDescuento(@PathVariable String descuento) {
        return museoRepository.getMuseoByDescuento(descuento);
    }
}
