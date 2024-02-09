package com.example.reto5diturismo.controller;

import com.example.reto5diturismo.model.Evento;
import com.example.reto5diturismo.model.Gastronomia;
import com.example.reto5diturismo.repository.EventoRepository;
import com.example.reto5diturismo.repository.GastronomiaRepository;
import com.example.reto5diturismo.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/turismo")
public class EventosController {

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private SecurityService securityService;

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

    @PostMapping("/evento")
    public ResponseEntity<Evento> nuevo(@RequestBody Evento evento, @RequestParam String token) {
        if (securityService.tokenDeValidacion(token)) {
            return new ResponseEntity<Evento>(eventoRepository.save(evento), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
/*
    @PostMapping("/evento")
    public ResponseEntity<Evento> put(@PathVariable Integer id, @RequestBody Evento nuevoEvento, @RequestParam String token){
        if (!securityService.tokenDeValidacion(token)) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } else {
            Evento evento = new Evento();
            var eventoOpcional = eventoRepository.findById(id);
            if (eventoOpcional.isEmpty()) {
                evento = nuevoEvento;
            } else {
                evento = eventoOpcional.get();
                evento.setNombre(nuevoEvento.getNombre());
                evento.setPrecio(nuevoEvento.getPrecio());
                evento.setDireccion(nuevoEvento.getDireccion());
                evento.setTematica(nuevoEvento.getTematica());
                evento.setEpoca_del_anho(nuevoEvento.getEpoca_del_anho());
            }
            return new ResponseEntity<Evento>(eventoRepository.save(evento), HttpStatus.OK);
        }
    }
    */
}
