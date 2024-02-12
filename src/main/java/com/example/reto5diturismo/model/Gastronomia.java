package com.example.reto5diturismo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

/**
 * Clase que representa un plato gastronómico.
 */
@Data
@Entity
@Table(name = "gastronomia")
public class Gastronomia implements Serializable {
    /**
     * Identificador único del plato de gastronomía, generado automáticamente por la Base de Datos.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Nombre del plato de gastronomía.
     */
    private String nombre;

    /**
     * Descripción detallada del plato de gastronomía.
     */
    private String descripcion;

    /**
     * Origen del plato de gastronomía, indicando la región o país de donde proviene.
     */
    private String origen;
}
