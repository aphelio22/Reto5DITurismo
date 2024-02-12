package com.example.reto5diturismo.repository;

import com.example.reto5diturismo.model.Evento;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Interfaz que proporciona métodos de acceso a datos para la entidad {@code Evento}.
 */
public interface EventoRepository extends JpaRepository<Evento, Integer> {
    /**
     * Obtiene un evento por su identificador único.
     *
     * @param id El identificador único del evento.
     * @return El evento con el identificador proporcionado, o {@code null} si no se encuentra.
     */
    public Evento getEventoById(Integer id);

    /**
     * Obtiene un evento por su nombre.
     *
     * @param nombre El nombre del evento.
     * @return El evento con el nombre proporcionado, o {@code null} si no se encuentra.
     */
    public Evento getEventoByNombre(String nombre);

    /**
     * Obtiene una lista de eventos cuyo precio es anterior al valor proporcionado.
     *
     * @param precio El precio límite para la búsqueda.
     * @return Una lista de eventos con precios inferiores al valor proporcionado.
     */
    public List<Evento> getEventoByPrecioBefore(Double precio);

    /**
     * Obtiene una lista de eventos por su temática.
     *
     * @param tematica La temática o categoría de los eventos.
     * @return Una lista de eventos que pertenecen a la temática proporcionada.
     */
    public List<Evento> getEventoByTematica(String tematica);
}