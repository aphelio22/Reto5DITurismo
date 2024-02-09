package com.example.reto5diturismo.model;

import com.example.reto5diturismo.enums.Descuento;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "museo")
public class Museo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private Double precio;
    private String direccion;
    private String descripcion;
    private String tematica;
    @Enumerated(EnumType.STRING)
    private Descuento descuento;
}
