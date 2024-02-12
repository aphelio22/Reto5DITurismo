package com.example.reto5diturismo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

/**
 * Clase que representa un punto de interés.
 */
@Data
@Entity
@Table(name = "punto_interes")
public class Punto_Interes implements Serializable {
    /**
     * Identificador único del punto de interés, generado automáticamente por la Base de Datos.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Nombre del punto de interés.
     */
    private String nombre;

    /**
     * Dirección del punto de interés.
     */
    private String direccion;

    /**
     * Descripción detallada del punto de interés.
     */
    private String descripcion;
}
