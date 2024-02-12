package com.example.reto5diturismo.repository;

import com.example.reto5diturismo.model.Museo;
import com.example.reto5diturismo.model.Punto_Interes;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interfaz que proporciona métodos de acceso a datos para la entidad {@code Museo}.
 */
public interface Punto_InteresRepository extends JpaRepository<Punto_Interes, Integer> {
    /**
     * Obtiene un punto de interés por su identificador único.
     *
     * @param id El identificador único del punto de interés.
     * @return El punto de interés con el identificador proporcionado, o {@code null} si no se encuentra.
     */
    public Punto_Interes getPunto_InteresById(Integer id);

    /**
     * Obtiene un punto de interés por su nombre.
     *
     * @param nombre El nombre del punto de interés.
     * @return El punto de interés con el nombre proporcionado, o {@code null} si no se encuentra.
     */
    public Punto_Interes getPunto_InteresByNombre(String nombre);
}
