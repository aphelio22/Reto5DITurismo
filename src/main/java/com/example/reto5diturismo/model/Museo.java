package com.example.reto5diturismo.model;

import com.example.reto5diturismo.enums.Descuento;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;

import java.io.Serializable;

/**
 * Clase que representa un museo.
 */
@Data
@Entity
@Table(name = "museo")
public class Museo implements Serializable {
    /**
     * Identificador único del museo, generado automáticamente por la Base de Datos.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Nombre del museo.
     */
    private String nombre;

    /**
     * Precio de entrada al museo.
     */
    private Double precio;

    /**
     * Dirección del museo.
     */
    private String direccion;

    /**
     * Descripción detallada del museo.
     */
    private String descripcion;

    /**
     * Temática o categoría a la que pertenece el museo.
     */
    private String tematica;

    /**
     * Descuento aplicable al museo, representado como un enum de descuentos.
     */
    @Enumerated(EnumType.STRING)
    private Descuento descuento;
}
