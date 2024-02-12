package com.example.reto5diturismo.repository;

import com.example.reto5diturismo.model.Evento;
import com.example.reto5diturismo.model.Gastronomia;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interfaz que proporciona métodos de acceso a datos para la entidad {@code Gastronomia}.
 */
public interface GastronomiaRepository extends JpaRepository<Gastronomia, Integer> {
    /**
     * Obtiene un plato gastronómico por su identificador único.
     *
     * @param id El identificador único del plato gastronómico.
     * @return El plato gastronómico con el identificador proporcionado, o {@code null} si no se encuentra.
     */
    public Gastronomia getGastronomiaById(Integer id);

    /**
     * Obtiene un plato gastronómico por su origen.
     *
     * @param origen El origen del plato gastronómico, indicando la región o país de donde proviene.
     * @return El plato gastronómico con el origen proporcionado, o {@code null} si no se encuentra.
     */
    public Gastronomia getGastronomiaByOrigen(String origen);

    /**
     * Obtiene un plato gastronómico por su nombre.
     *
     * @param nombre El nombre del plato gastronómico.
     * @return El plato gastronómico con el nombre proporcionado, o {@code null} si no se encuentra.
     */
    public Gastronomia getGastronomiaByNombre(String nombre);
}
