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

/**
 * Controlador REST que gestiona las operaciones relacionadas con los eventos.
 */
@RestController
@RequestMapping("/api/turismo")
public class EventosController {

    /**
     * Enlace al repositorio de eventos.
     */
    @Autowired
    private EventoRepository eventoRepository;

    /**
     * Enlace al servicio de seguridad.
     */
    @Autowired
    private SecurityService securityService;

    //Tabla Evento
    /**
     * Obtiene todos los eventos disponibles.
     *
     * @return Lista de eventos.
     */
    @GetMapping("/evento")
    public List<Evento> getAllEventos() {
        return eventoRepository.findAll();
    }

    /**
     * Obtiene un evento por su identificador único.
     *
     * @param id El identificador único del evento.
     * @return El evento con el identificador proporcionado.
     */
    @GetMapping("/evento/id/{id}")
    public Evento getById(@PathVariable Integer id) {
        return eventoRepository.getEventoById(id);
    }

    /**
     * Obtiene un evento por su nombre.
     *
     * @param nombre El nombre del evento.
     * @return El evento con el nombre proporcionado.
     */
    @GetMapping("/evento/nombre/{nombre}")
    public Evento getEventobyNombre(@PathVariable String nombre) {
        return eventoRepository.getEventoByNombre(nombre);
    }

    /**
     * Obtiene eventos con un precio inferior al proporcionado.
     *
     * @param precio El precio máximo de los eventos a buscar.
     * @return Lista de eventos con precio inferior al proporcionado.
     */
    @GetMapping("/evento/precio/{precio}")
    public List<Evento> getEventobyPrecio(@PathVariable Double precio) {
        return eventoRepository.getEventoByPrecioBefore(precio);
    }

    /**
     * Obtiene eventos por temática.
     *
     * @param tematica La temática de los eventos.
     * @return Lista de eventos con la temática proporcionada.
     */
    @GetMapping("/evento/tematica/{tematica}")
    public List<Evento> getEventobyTematica(@PathVariable String tematica) {
        return eventoRepository.getEventoByTematica(tematica);
    }

    /**
     * Crea un nuevo evento.
     *
     * @param evento El evento a crear.
     * @param token El token de autenticación.
     * @return ResponseEntity con el resultado de la operación.
     */
    @PostMapping("/evento/post")
    public ResponseEntity<Evento> nuevo(@RequestBody Evento evento, @RequestParam String token) {
        if (securityService.tokenDeValidacion(token)) {
            return new ResponseEntity<Evento>(eventoRepository.save(evento), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    /**
     * Actualiza un evento existente.
     *
     * @param id El identificador único del evento a actualizar.
     * @param nuevoEvento Los nuevos datos del evento.
     * @param token El token de autenticación.
     * @return ResponseEntity con el resultado de la operación.
     */
    @PutMapping("/evento/put/{id}")
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

    /**
     * Elimina un evento por su identificador único.
     *
     * @param id El identificador único del evento a eliminar.
     * @param token El token de autenticación.
     * @return ResponseEntity con el resultado de la operación.
     */
    @DeleteMapping("/evento/delete/{id}")
    public ResponseEntity<Evento> delete(@PathVariable Integer id,  @RequestParam String token){
        ResponseEntity<Evento> respuesta = new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        if( securityService.tokenDeValidacion(token) ){
            Evento salida = new Evento();
            if (eventoRepository.existsById(id)) {
                salida = eventoRepository.findById(id).get();
                eventoRepository.deleteById(id);
                respuesta = new ResponseEntity<Evento>(salida, HttpStatus.OK);
            } else {
                respuesta = new ResponseEntity<Evento>(salida, HttpStatus.NOT_FOUND);
            }
        }
        return respuesta;
    }
}
