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

/**
 * Controlador REST que gestiona las operaciones relacionadas con los platos gastronomicos.
 */
@RestController
@RequestMapping("/api/turismo")
public class GastronomiaController {

    /**
     * Enlace al repositorio de platos gastronomicos.
     */
    @Autowired
    private GastronomiaRepository gastronomiaRepository;

    /**
     * Enlace al servicio de seguridad.
     */
    @Autowired
    private SecurityService securityService;

    //Tabla Gastronomia.
    /**
     * Obtiene todos los platos gastronómicos disponibles.
     *
     * @return Lista de platos gastronómicos.
     */
    @GetMapping("/gastronomia")
    public List<Gastronomia> getAllGastroPlato() {
        return gastronomiaRepository.findAll();
    }

    /**
     * Obtiene un plato gastronómico por su identificador único.
     *
     * @param id El identificador único del plato gastronómico.
     * @return El plato gastronómico con el identificador proporcionado.
     */
    @GetMapping("/gastronomia/id/{id}")
    public Gastronomia getGastroPlatobyId(@PathVariable Integer id) {
        return gastronomiaRepository.getGastronomiaById(id);
    }

    /**
     * Obtiene un plato gastronómico por su origen.
     *
     * @param origen El origen del plato gastronómico.
     * @return El plato gastronómico con el origen proporcionado.
     */
    @GetMapping("/gastronomia/origen/{origen}")
    public List<Gastronomia> getGastroPlatobyOrigen(@PathVariable String origen) {
        return gastronomiaRepository.getGastronomiaByOrigen(origen);
    }

    /**
     * Obtiene un plato gastronómico por su nombre.
     *
     * @param nombre El nombre del plato gastronómico.
     * @return El plato gastronómico con el nombre proporcionado.
     */
    @GetMapping("/gatronomia/nombre/{nombre}")
    public Gastronomia getGastroPlatobyNombre(@PathVariable String nombre) {
        return gastronomiaRepository.getGastronomiaByNombre(nombre);
    }

    /**
     * Crea un nuevo plato gastronómico.
     *
     * @param gastronomia El plato gastronómico a crear.
     * @param token El token de autenticación.
     * @return ResponseEntity con el resultado de la operación.
     */
    @PostMapping("/gastronomia/post")
    public ResponseEntity<Gastronomia> nuevo(@RequestBody Gastronomia gastronomia, @RequestParam String token) {
        if (securityService.tokenDeValidacion(token)) {
            return new ResponseEntity<Gastronomia>(gastronomiaRepository.save(gastronomia), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    /**
     * Actualiza un plato gastronómico existente.
     *
     * @param id El identificador único del plato gastronómico a actualizar.
     * @param nuevoGastro Los nuevos datos del plato gastronómico.
     * @param token El token de autenticación.
     * @return ResponseEntity con el resultado de la operación.
     */
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

    /**
     * Elimina un plato gastronómico por su identificador único.
     *
     * @param id El identificador único del plato gastronómico a eliminar.
     * @param token El token de autenticación.
     * @return ResponseEntity con el resultado de la operación.
     */
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
