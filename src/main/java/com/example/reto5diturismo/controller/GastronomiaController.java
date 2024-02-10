package com.example.reto5diturismo.controller;

import com.example.reto5diturismo.model.Evento;
import com.example.reto5diturismo.model.Gastronomia;
import com.example.reto5diturismo.repository.EventoRepository;
import com.example.reto5diturismo.repository.GastronomiaRepository;
import com.example.reto5diturismo.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/turismo")
public class GastronomiaController {

    @Autowired
    private GastronomiaRepository gastronomiaRepository;

    @Autowired
    private SecurityService securityService;

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

    @PostMapping("/gastronomia/post")
    public ResponseEntity<Gastronomia> nuevo(@RequestBody Gastronomia gastronomia, @RequestParam String token) {
        if (securityService.tokenDeValidacion(token)) {
            return new ResponseEntity<Gastronomia>(gastronomiaRepository.save(gastronomia), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @PutMapping("/gastronomia/put/{id}")
    public ResponseEntity<Gastronomia> put(@PathVariable Integer id, @RequestBody Gastronomia nuevoGastro, @RequestParam String token){
        if (!securityService.tokenDeValidacion(token)) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } else {
            Gastronomia gastronomia = new Gastronomia();
            var gastroOpcional = gastronomiaRepository.findById(id);
            if (gastroOpcional.isEmpty()) {
                gastronomia = nuevoGastro;
            } else {
                gastronomia = gastroOpcional.get();
                gastronomia.setNombre(nuevoGastro.getNombre());
                gastronomia.setDescripcion(nuevoGastro.getDescripcion());
                gastronomia.setOrigen(nuevoGastro.getOrigen());
            }
            return new ResponseEntity<Gastronomia>(gastronomiaRepository.save(gastronomia), HttpStatus.OK);
        }
    }

    @DeleteMapping("/gastronomia/delete/{id}")
    public ResponseEntity<Gastronomia> delete(@PathVariable Integer id,  @RequestParam String token){
        ResponseEntity<Gastronomia> respuesta = new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        if( securityService.tokenDeValidacion(token) ){
            Gastronomia salida = new Gastronomia();
            if (gastronomiaRepository.existsById(id)) {
                salida = gastronomiaRepository.findById(id).get();
                gastronomiaRepository.deleteById(id);
                respuesta = new ResponseEntity<Gastronomia>(salida, HttpStatus.OK);
            } else {
                respuesta = new ResponseEntity<Gastronomia>(salida, HttpStatus.NOT_FOUND);
            }
        }
        return respuesta;
    }
}
