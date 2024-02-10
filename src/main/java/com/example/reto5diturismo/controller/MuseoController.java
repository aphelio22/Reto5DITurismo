package com.example.reto5diturismo.controller;

import com.example.reto5diturismo.enums.Descuento;
import com.example.reto5diturismo.model.Gastronomia;
import com.example.reto5diturismo.model.Museo;
import com.example.reto5diturismo.repository.MuseoRepository;
import com.example.reto5diturismo.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/turismo")
public class MuseoController {

    @Autowired
    private MuseoRepository museoRepository;

    @Autowired
    private SecurityService securityService;

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

    @PostMapping("/museo/post")
    public ResponseEntity<Museo> nuevo(@RequestBody Museo museo, @RequestParam String token) {
        if (securityService.tokenDeValidacion(token)) {
            return new ResponseEntity<Museo>(museoRepository.save(museo), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @PutMapping("/museo/put/{id}")
    public ResponseEntity<Museo> put(@PathVariable Integer id, @RequestBody Museo nuevoMuseo, @RequestParam String token){
        if (!securityService.tokenDeValidacion(token)) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } else {
            Museo museo = new Museo();
            var museoOpcional = museoRepository.findById(id);
            if (museoOpcional.isEmpty()) {
                museo = nuevoMuseo;
            } else {
                museo = museoOpcional.get();
                museo.setNombre(nuevoMuseo.getNombre());
                museo.setPrecio(nuevoMuseo.getPrecio());
                museo.setDireccion(nuevoMuseo.getDireccion());
                museo.setDescripcion(nuevoMuseo.getDescripcion());
                museo.setTematica(nuevoMuseo.getTematica());
                museo.setDescuento(nuevoMuseo.getDescuento());
            }
            return new ResponseEntity<Museo>(museoRepository.save(museo), HttpStatus.OK);
        }
    }

    @DeleteMapping("/museo/delete/{id}")
    public ResponseEntity<Museo> delete(@PathVariable Integer id,  @RequestParam String token){
        ResponseEntity<Museo> respuesta = new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        if( securityService.tokenDeValidacion(token) ){
            Museo salida = new Museo();
            if (museoRepository.existsById(id)) {
                salida = museoRepository.findById(id).get();
                museoRepository.deleteById(id);
                respuesta = new ResponseEntity<Museo>(salida, HttpStatus.OK);
            } else {
                respuesta = new ResponseEntity<Museo>(salida, HttpStatus.NOT_FOUND);
            }
        }
        return respuesta;
    }
}
