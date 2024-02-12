package com.example.reto5diturismo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

/**
 * Clase que representa un evento.
 */
@Data
@Entity
@Table(name = "evento")
public class Evento implements Serializable {
    /**
     * Identificador único del evento, generado automáticamente por la Base de Datos.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Nombre del evento.
     */
    private String nombre;

    /**
     * Precio del evento.
     */
    private Double precio;

    /**
     * Dirección donde se llevará a cabo el evento.
     */
    private String direccion;

    /**
     * Temática o categoría a la que pertenece el evento.
     */
    private String tematica;

    /**
     * Época del año en la que tiene lugar el evento.
     */
    private String epoca_del_anho;
}
