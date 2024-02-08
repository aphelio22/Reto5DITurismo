package com.example.reto5diturismo.controller;

import com.example.reto5diturismo.model.Evento;
import com.example.reto5diturismo.model.Gastronomia;
import com.example.reto5diturismo.repository.EventoRepository;
import com.example.reto5diturismo.repository.GastronomiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/turismo")
public class EventosController {

    @Autowired
    private EventoRepository eventoRepository;

    //Tabla Evento
    @GetMapping("/evento")
    public List<Evento> getAllEventos() {
        return eventoRepository.findAll();
    }

    @GetMapping("/evento/id/{id}")
    public Evento getById(@PathVariable Integer id) {
        return eventoRepository.getEventoById(id);
    }

    @GetMapping("/evento/nombre/{nombre}")
    public Evento getEventobyNombre(@PathVariable String nombre) {
        return eventoRepository.getEventoByNombre(nombre);
    }

    @GetMapping("/evento/precio/{precio}")
    public List<Evento> getEventobyPrecio(@PathVariable Double precio) {
        return eventoRepository.getEventoByPrecioBefore(precio);
    }

    @GetMapping("/evento/tematica/{tematica}")
    public List<Evento> getEventobyTematica(@PathVariable String tematica) {
        return eventoRepository.getEventoByTematica(tematica);
    }
}
