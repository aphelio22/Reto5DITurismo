package com.example.reto5diturismo.controller;

import com.example.reto5diturismo.model.Museo;
import com.example.reto5diturismo.model.Punto_Interes;
import com.example.reto5diturismo.repository.Punto_InteresRepository;
import com.example.reto5diturismo.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/turismo")
public class Punto_InteresController {

    @Autowired
    private Punto_InteresRepository puntoInteresRepository;

    @Autowired
    private SecurityService securityService;

    //Tabla Punto_Interes.
    @GetMapping("/punto_interes")
    public List<Punto_Interes> getAllPuntoInteres() {
        return puntoInteresRepository.findAll();
    }

    @GetMapping("/punto_interes/id/{id}")
    public Punto_Interes getPunto_InteresById(@PathVariable Integer id) {
        return puntoInteresRepository.getPunto_InteresById(id);
    }

    @GetMapping("/punto_interes/nombre/{nombre}")
    public Punto_Interes getPunto_InteresByNombre(@PathVariable String nombre) {
        return puntoInteresRepository.getPunto_InteresByNombre(nombre);
    }

    @PostMapping("/punto_interes/post")
    public ResponseEntity<Punto_Interes> nuevo(@RequestBody Punto_Interes puntoInteres, @RequestParam String token) {
        if (securityService.tokenDeValidacion(token)) {
            return new ResponseEntity<Punto_Interes>(puntoInteresRepository.save(puntoInteres), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @PutMapping("/punto_interes/put/{id}")
    public ResponseEntity<Punto_Interes> put(@PathVariable Integer id, @RequestBody Punto_Interes nuevoPuntoInteres, @RequestParam String token){
        if (!securityService.tokenDeValidacion(token)) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } else {
            Punto_Interes punto_interes = new Punto_Interes();
            var puntoInteresOpcional = puntoInteresRepository.findById(id);
            if (puntoInteresOpcional.isEmpty()) {
                punto_interes = nuevoPuntoInteres;
            } else {
                punto_interes = puntoInteresOpcional.get();
                punto_interes.setNombre(nuevoPuntoInteres.getNombre());
                punto_interes.setDireccion(nuevoPuntoInteres.getDireccion());
                punto_interes.setDescripcion(nuevoPuntoInteres.getDescripcion());
            }
            return new ResponseEntity<Punto_Interes>(puntoInteresRepository.save(punto_interes), HttpStatus.OK);
        }
    }

    @DeleteMapping("/punto_interes/delete/{id}")
    public ResponseEntity<Punto_Interes> delete(@PathVariable Integer id,  @RequestParam String token){
        ResponseEntity<Punto_Interes> respuesta = new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        if( securityService.tokenDeValidacion(token) ){
            Punto_Interes salida = new Punto_Interes();
            if (puntoInteresRepository.existsById(id)) {
                salida = puntoInteresRepository.findById(id).get();
                puntoInteresRepository.deleteById(id);
                respuesta = new ResponseEntity<Punto_Interes>(salida, HttpStatus.OK);
            } else {
                respuesta = new ResponseEntity<Punto_Interes>(salida, HttpStatus.NOT_FOUND);
            }
        }
        return respuesta;
    }
}
